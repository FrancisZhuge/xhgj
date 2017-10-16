package com.dou.xhgj.service.permission.impl;

import com.dou.xhgj.dao.permission.PermissionDao;
import com.dou.xhgj.domain.PageResult;
import com.dou.xhgj.domain.permission.Permission;
import com.dou.xhgj.service.permission.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/10/16, 11:10
 * @Modified By:
 * @Email: franciszhuge@163.com
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class PermissionServiceImpl implements PermissionService{
    private final static Logger LOGGER = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @Autowired
    PermissionDao permissionDao;

    @Override
    public Permission savePermission(Permission permission) {
        try {
            permissionDao.savePermission(permission);
        } catch (Exception e) {
            LOGGER.error("[savePermission] failed, permission = {}",permission.getPermission(),e);
        }
        return permission;
    }

    @Override
    public void deleteById(Long permissionId) {
        /**
         * 首先删除中间表数据，然后在删除本表数据
         */
        try {
            permissionDao.deleteRoleAndPermission(permissionId);
            permissionDao.deletePermission(permissionId);
        } catch (Exception e) {
            LOGGER.error("[deleteById] failed, permissionId = {}",permissionId,e);
        }
    }

    @Override
    public PageResult<Permission> getPageResult(int pageNo, int pageSize) {
        int start = pageNo*pageSize;
        int limit = pageSize;
        int totalCount = 0;
        List<Permission> users = null;
        try {
            totalCount = permissionDao.count();
            users = permissionDao.list(start, limit);
        } catch (Exception e) {
            LOGGER.error("[getPageResult] failed, ",e);
        }
        return new PageResult<>(totalCount,pageNo,pageSize,users);
    }

    @Override
    public PageResult<Permission> getPageResultByPermission(String permission, int pageNo, int pageSize) {
        int start = pageNo*pageSize;
        int limit = pageSize;
        int count = 0;
        List<Permission> users = null;
        try {
            count = permissionDao.countByPermission(permission);
            users = permissionDao.listByPermission(permission, start, limit);
        } catch (Exception e) {
            LOGGER.error("[getPageResultByPermission] failed, ",e);
        }
        return new PageResult<>(count,pageNo,pageSize,users);
    }

    @Override
    public Permission getPermissionByPermission(String permission) {
        Permission permission1 = null;
        try {
            permission1 = permissionDao.getByPermission(permission);
        } catch (Exception e) {
            LOGGER.error("[getPermissionByPermission] failed, ",e);
        }
        return permission1;
    }

    @Override
    public void updateState(long id) {
        try {
            Permission permission = getPermissionById(id);
            if(permission.getAvailable().equals(true)){
                permission.setAvailable(false);
            }else {
                permission.setAvailable(true);
            }
            permissionDao.update(permission);
        } catch (Exception e) {
            LOGGER.error("[updateState] failed, ",e);
        }
    }

    @Override
    public Permission getPermissionById(long id) {
        Permission permissionById = null;
        try {
            permissionDao.getPermissionById(id);
        } catch (Exception e) {
            LOGGER.error("[getPermissionById] failed, ",e);
        }
        return permissionById;
    }
}
