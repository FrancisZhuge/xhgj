package com.dou.xhgj.service.permission;

import com.dou.xhgj.domain.PageResult;
import com.dou.xhgj.domain.permission.Permission;

/**
 * @Author: Francis Zhuge
 * @Description: Permission的Service接口类
 * @Date: Created in 2017/10/16, 11:02
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public interface PermissionService {
    /**
     * 新增权限
     * @param permission
     * @return
     */
    Permission savePermission(Permission permission);

    /**
     * 删除权限
     * @param permissionId
     */
    void deleteById(Long permissionId);

    /**
     * 分页查找
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult<Permission> getPageResult(int pageNo, int pageSize);

    /**
     * 根据条件分页查找
     * @param permission
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult<Permission> getPageResultByPermission(String permission, int pageNo, int pageSize);

    /**
     * 根据permission查找Permission
     * @param permission
     * @return
     */
    Permission getPermissionByPermission(String permission);

    /**
     * 更改指定权限的状态
     * @param id
     */
    void updateState(long id);

    /**
     * 根据主键查找
     * @param id
     * @return
     */
    Permission getPermissionById(long id);
}
