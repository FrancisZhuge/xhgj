package com.dou.xhgj.web.controller.permission;

import com.alibaba.fastjson.JSONObject;
import com.dou.xhgj.domain.PageResult;
import com.dou.xhgj.domain.permission.Permission;
import com.dou.xhgj.service.permission.PermissionService;
import com.dou.xhgj.web.response.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Francis Zhuge
 * @Description: 权限控制器
 * @Date: Created in 2017/10/16, 11:34
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Controller
@RequestMapping("/xhgj/backend/permission")
public class PermissionController {
    private final static Logger LOGGER = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private PermissionService permissionService;

    /**
     * 分页查找权限
     * @param searchPermission
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value ="/list",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAll(@RequestParam(value = "searchPermission", required = false, defaultValue = "") String searchPermission,
                         @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNo,
                         @RequestParam(value = "pageSize", required = false ,defaultValue = "10") int pageSize){
        PageResult<Permission> pageResult = null;
        try {
            if(StringUtils.isEmpty(searchPermission)){
                pageResult = permissionService.getPageResult(pageNo,pageSize);
            }else {
                pageResult = permissionService.getPageResultByPermission(searchPermission, pageNo, pageSize);
            }
        } catch (Exception e) {
            LOGGER.error("[getAll] get permission list failed",e);
            return ResponseUtil.responseServerError();
        }
        JSONObject data = new JSONObject();
        data.put("data",pageResult);
        data.put("searchPermission",searchPermission);
        return ResponseUtil.responseOkWithData(data);
    }

    /**
     * 新增一个权限
     * @param permission
     * @param description
     * @return
     */
    @RequestMapping(value ="/add",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String add(@RequestParam(value = "permission") String permission,
                      @RequestParam(value = "description") String description){
        if(StringUtils.isEmpty(permission)){
            return ResponseUtil.responseIllegalArgus();
        }
        Permission byPermission = permissionService.getPermissionByPermission(permission);
        if(byPermission!=null){
            return ResponseUtil.responseServerError("该权限已经存在");
        }
        Permission permission1 = new Permission(permission,description);
        try {
            permissionService.savePermission(permission1);
            return ResponseUtil.responseOk();
        } catch (Exception e) {
            LOGGER.error("[add] add permission failed",e);
            return ResponseUtil.responseServerError();
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam("id") long id){
        try {
            permissionService.deleteById(id);
            return ResponseUtil.responseOk();
        } catch (Exception e) {
            LOGGER.error("[delete] delete permission failed",e);
            return ResponseUtil.responseServerError();
        }
    }
    @RequestMapping("/change")
    @ResponseBody
    public String change(@RequestParam("id") long id){
        try {
            permissionService.updateState(id);
            return ResponseUtil.responseOk();
        } catch (Exception e) {
            LOGGER.error("[delete] updateState permission failed",e);
            return ResponseUtil.responseServerError();
        }
    }
}
