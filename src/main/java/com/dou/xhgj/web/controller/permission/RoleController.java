package com.dou.xhgj.web.controller.permission;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.dou.xhgj.domain.PageResult;
import com.dou.xhgj.domain.permission.Role;
import com.dou.xhgj.domain.permission.RolePermissionVo;
import com.dou.xhgj.service.permission.RoleService;
import com.dou.xhgj.web.response.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/10/19, 10:20
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Controller
@RequestMapping("/xhgj/backend/role")
public class RoleController {
    private final static Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    /**
     * 分页查找权限
     * @param searchRole
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value ="/list",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAll(@RequestParam(value = "searchRole", required = false, defaultValue = "") String searchRole,
                         @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNo,
                         @RequestParam(value = "pageSize", required = false ,defaultValue = "10") int pageSize){
        PageResult<Role> pageResult = null;
        try {
            if(StringUtils.isEmpty(searchRole)){
                pageResult = roleService.getPageResult(pageNo,pageSize);
            }else {
                pageResult = roleService.getPageResultByRole(searchRole, pageNo, pageSize);
            }
        } catch (Exception e) {
            LOGGER.error("[getAll] get role list failed",e);
            return ResponseUtil.responseServerError();
        }
        JSONObject data = new JSONObject();
        data.put("data",pageResult);
        data.put("searchRole",searchRole);
        return ResponseUtil.responseOkWithData(data);
    }

    /**
     * 新增一个角色
     * @param role
     * @param description
     * @return
     */
    @RequestMapping(value ="/add",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String add(@RequestParam(value = "role") String role,
                      @RequestParam(value = "description") String description){
        if(StringUtils.isEmpty(role)){
            return ResponseUtil.responseIllegalArgus();
        }
        Role byRole = roleService.getByRole(role);
        if(byRole!=null){
            return ResponseUtil.responseServerError("该角色已经存在");
        }
        Role role1 = new Role(role,description);
        try {
            roleService.save(role1);
            return ResponseUtil.responseOk();
        } catch (Exception e) {
            LOGGER.error("[add] add permission failed",e);
            return ResponseUtil.responseServerError();
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam("id") long id){
        try {
            roleService.deleteById(id);
            return ResponseUtil.responseOk();
        } catch (Exception e) {
            LOGGER.error("[delete] delete role failed",e);
            return ResponseUtil.responseServerError();
        }
    }

    /**
     * 更改状态
     * @param id
     * @return
     */
    @RequestMapping("/change")
    @ResponseBody
    public String change(@RequestParam("id") long id){
        try {
            roleService.updateState(id);
            return ResponseUtil.responseOk();
        } catch (Exception e) {
            LOGGER.error("[delete] updateState role failed",e);
            return ResponseUtil.responseServerError();
        }
    }

    @RequestMapping(value = "/permissionsWithSelected", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getRoles(@RequestParam("roleid") Long id){
        JSONObject data = new JSONObject();
        try {
            List<RolePermissionVo> permissions = roleService.findAllPermissionswithAvailable();
            List<Integer> ids = roleService.findPermissionsByRoleId(id);
            for(int id1:ids){
                for(RolePermissionVo vo:permissions){
                    if(id1==vo.getId()){
                        vo.setSelected(true);
                    }
                }
            }
            data.put("permissions",permissions);
        } catch (Exception e) {
            LOGGER.error("[delete] getRoles failed",e);
            return ResponseUtil.responseServerError();
        }
        return ResponseUtil.responseOkWithData(data);
    }

    @RequestMapping(value = "/savePermissions")
    @ResponseBody
    public String saveUserRoles(@RequestParam("roleid") Long roleId,
                                @RequestParam("permissionid") List<Long> permissionIds){
        try {
            roleService.updatePermissions(roleId,permissionIds);
            return ResponseUtil.responseOk();
        } catch (Exception e) {
            LOGGER.error("[delete] saveUserRoles failed",e);
            return ResponseUtil.responseServerError();
        }
    }
}
