package com.dou.xhgj.service.permission.impl;

import com.dou.xhgj.dao.permission.RoleDao;
import com.dou.xhgj.domain.PageResult;
import com.dou.xhgj.domain.permission.Role;
import com.dou.xhgj.domain.permission.RolePermissionVo;
import com.dou.xhgj.service.permission.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/10/18, 20:58
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService{
    private final static Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role save(Role role) {
        try {
            roleDao.saveRole(role);
        }catch (Exception e){
            LOGGER.error("[RoleServiceImpl.createRole] failed, role = {}",role.getRole(),e);
        }
        return role;
    }

    @Override
    public void deleteById(Long roleId) {
        /**
         * 先删除中间表的数据
         * 在删除本表的数据
         */
        try {
            roleDao.deleteUserAndRole(roleId);
            roleDao.deleteRole(roleId);
        } catch (Exception e) {
            LOGGER.error("[RoleServiceImpl.deleteRole] failed, roleId = {}",roleId,e);
        }
    }

    @Override
    public void correlationPermissions(Long roleId, Long... permissionIds) {
        if(permissionIds == null || permissionIds.length == 0) {
            return;
        }
        try {
            for(Long permissionId:permissionIds){
                if(!exists(roleId,permissionId)){
                    roleDao.correlationPermission(roleId,permissionId);
                }
            }
        } catch (Exception e) {
            LOGGER.error("[RoleServiceImpl.correlationPermissions] failed, roleId = {},permissionIds = {}",roleId,permissionIds,e);
        }
    }

    @Override
    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
        if(permissionIds == null || permissionIds.length == 0) {
            return;
        }
        try {
            for(Long permissionId:permissionIds){
                if(exists(roleId,permissionId)){
                    roleDao.uncorrelationPermission(roleId,permissionId);
                }
            }
        } catch (Exception e) {
            LOGGER.error("[RoleServiceImpl.uncorrelationPermissions] failed, roleId = {},permissionIds = {}",roleId,permissionIds,e);
        }
    }

    @Override
    public PageResult<Role> getPageResult(int pageNo, int pageSize) {
        int start = pageNo*pageSize;
        int limit = pageSize;
        int totalCount = 0;
        List<Role> roles = null;
        try {
            totalCount = roleDao.count();
            roles = roleDao.list(start, limit);
        } catch (Exception e) {
            LOGGER.error("[RoleServiceImpl.getPageResult] failed",e);
        }
        return new PageResult<>(totalCount,pageNo,pageSize,roles);
    }

    @Override
    public PageResult<Role> getPageResultByRole(String role, int pageNo, int pageSize) {
        int start = pageNo*pageSize;
        int limit = pageSize;
        int count = 0;
        List<Role> users = null;
        try {
            count = roleDao.countByRole(role);
            users = roleDao.listByRole(role, start, limit);
        } catch (Exception e) {
            LOGGER.error("[RoleServiceImpl.getPageResultByRole] failed",e);
        }
        return new PageResult<>(count,pageNo,pageSize,users);
    }

    @Override
    public Role getByRole(String role) {
        Role role1 = null;
        try {
            role1 = roleDao.getByRole(role);
        } catch (Exception e) {
            LOGGER.error("[getByRole] failed, ",e);
        }
        return role1;
    }

    @Override
    public void updateState(long id) {
        try {
            Role role = getRoleById(id);
            if(role.getAvailable().equals(true)){
                role.setAvailable(false);
            }else {
                role.setAvailable(true);
            }
            roleDao.update(role);
        } catch (Exception e) {
            LOGGER.error("[updateState] failed, ",e);
        }
    }

    @Override
    public Role getRoleById(long id) {
        Role roleById = null;
        try {
            roleById = roleDao.getRoleById(id);
        } catch (Exception e) {
            LOGGER.error("[getRoleById] failed, ",e);
        }
        return roleById;
    }

    @Override
    public List<RolePermissionVo> findAllPermissionswithAvailable() {
        return roleDao.findAllPermissionswithAvailable();
    }

    @Override
    public List<Integer> findPermissionsByRoleId(Long id) {
        return roleDao.findPermissionsByRoleId(id);
    }

    @Override
    public void updatePermissions(Long roleId, List<Long> permissionIds) {
        try {
            roleDao.uncorrelationPermissions(roleId);
            for(Long permissionId:permissionIds){
                roleDao.correlationPermission(roleId,permissionId);
            }
        } catch (Exception e) {
            LOGGER.error("[updatePermissions] failed, ",e);
        }
    }


    /**
     * 判断中间表中是否有对应的数据
     * @param roleId
     * @param permissionId
     * @return
     */
    private boolean exists(Long roleId, Long permissionId){
        int exists = roleDao.exists(roleId,permissionId);
        if(exists==0)
            return false;
        else
            return true;
    }
}
