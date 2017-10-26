package com.dou.xhgj.web.controller.permission;

import com.alibaba.fastjson.JSONObject;
import com.dou.xhgj.domain.PageResult;
import com.dou.xhgj.domain.UserInfo;
import com.dou.xhgj.domain.permission.UserRoleVo;
import com.dou.xhgj.service.permission.UserService;
import com.dou.xhgj.web.response.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/10/19, 15:07
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Controller
@RequestMapping("/xhgj/backend/user")
public class UserController {
    private final static Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private UserService userService;

    /**
     * 分页查找权限
     * @param searchUsername
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value ="/list",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAll(@RequestParam(value = "searchUsername", required = false, defaultValue = "") String searchUsername,
                         @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pageNo,
                         @RequestParam(value = "pageSize", required = false ,defaultValue = "10") int pageSize){
        PageResult<UserInfo> pageResult = null;
        try {
            if(StringUtils.isEmpty(searchUsername)){
                pageResult = userService.getPageResult(pageNo,pageSize);
            }else {
                pageResult = userService.getPageResultByUsername(searchUsername, pageNo, pageSize);
            }
        } catch (Exception e) {
            LOGGER.error("[getAll] get user list failed",e);
            return ResponseUtil.responseServerError();
        }
        JSONObject data = new JSONObject();
        data.put("data",pageResult);
        data.put("searchUsername",searchUsername);
        return ResponseUtil.responseOkWithData(data);
    }
    /**
     * 新增一个用户
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value ="/add",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String add(@RequestParam(value = "username" ,required = false) String username,
                      @RequestParam(value = "password" ,required = false) String password){
        if(StringUtils.isEmpty(username)){
            return ResponseUtil.responseIllegalArgus("用户名为空");
        }
        if(StringUtils.isEmpty(password)){
            return ResponseUtil.responseIllegalArgus("密码为空");
        }
        UserInfo user = userService.getByUsername(username);
        if(user!=null){
            return ResponseUtil.responseIllegalArgus("该角色已经存在");
        }
        UserInfo userInfo = new UserInfo(username,password);

        try {
            userService.save(userInfo);
            return ResponseUtil.responseOk();
        } catch (Exception e) {
            LOGGER.error("[add] add userInfo failed",e);
            return ResponseUtil.responseServerError();
        }
    }

    /**
     * 根据主键删除用户
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam(value = "id", required = false) Long id){
        if(id == null){
            return ResponseUtil.responseIllegalArgus();
        }
        try {
            userService.deleteById(id);
        } catch (Exception e) {
            LOGGER.error("[delete] delete userInfo fail, ",e);
            return ResponseUtil.responseServerError();
        }
        return ResponseUtil.responseOk();
    }

    /**
     * 更改用户的状态
     * @param id
     * @return
     */
    @RequestMapping("/change")
    @ResponseBody
    public String change(@RequestParam(value = "id",required = false) Long id){
        if(id == null){
            return ResponseUtil.responseIllegalArgus();
        }
        try {
            userService.changeState(id);
        } catch (Exception e) {
            return ResponseUtil.responseIllegalArgus();
        }
        return ResponseUtil.responseOk();
    }

    /**
     * 获取指定的userId的权限信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/rolesWithSelected",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getRoles(@RequestParam(value = "id",required = false) Long id){
        if(id == null){
            return ResponseUtil.responseIllegalArgus();
        }
        JSONObject data = new JSONObject();
        List<UserRoleVo> rolesByIdwithAvailable = null;
        try {
            rolesByIdwithAvailable = userService.findAllRoleswithAvailable();
            List<Integer> ids = userService.findRolesByUserId(id);
            for(int id1:ids){
                for(UserRoleVo roleVo:rolesByIdwithAvailable){
                    if(id1==roleVo.getId()){
                        roleVo.setSelected(true);
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("[getRoles] getRoles userInfo fail, ",e);
            return ResponseUtil.responseServerError();
        }
        data.put("data",rolesByIdwithAvailable);
        return ResponseUtil.responseOkWithData(data);
    }

    /**
     * 更新角色信息
     * @param userId
     * @param roleIds
     * @return
     */
    @RequestMapping("/saveRoles")
    @ResponseBody
    public String saveUserRoles(@RequestParam(value = "userId",required = false) Long userId,
                                @RequestParam(value = "roleId",required = false) List<Long> roleIds){
        if (userId == null){
            return ResponseUtil.responseIllegalArgus();
        }
        try {
            if(roleIds == null){
                return ResponseUtil.responseOk();
            }
            userService.updateRoles(userId,roleIds);
        } catch (Exception e) {
            LOGGER.error("[saveUserRoles] saveUserRoles fail, ",e);
            return ResponseUtil.responseServerError();
        }
        return ResponseUtil.responseOk();
    }
}
