package com.dou.xhgj.service.permission;

import com.dou.xhgj.domain.PageResult;
import com.dou.xhgj.domain.permission.Role;
import com.dou.xhgj.domain.permission.RolePermissionVo;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/10/18, 19:58
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public interface RoleService {
    /**
     * 新建权限
     * @param role
     * @return
     */
    Role save(Role role);

    /**
     * 删除权限
     * @param roleId
     */
    void deleteById(Long roleId);

    /**
     * 添加角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    void correlationPermissions(Long roleId, Long... permissionIds);

    /**
     * 移除角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    void uncorrelationPermissions(Long roleId, Long... permissionIds);

    /**
     * 分页查找
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult<Role> getPageResult(int pageNo, int pageSize);

    /**
     * 根据用户名分页查找
     * @param role
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult<Role> getPageResultByRole(String role, int pageNo, int pageSize);

    /**
     * 根据角色名查找
     * @param role
     * @return
     */
    Role getByRole(String role);

    /**
     * 更改角色的可获得状态
     * @param id
     */
    void updateState(long id);

    /**
     * 根据主键查找角色
     * @param id
     * @return
     */
    Role getRoleById(long id);

    /**
     * 获取系统中所有可用的权限
     * @return
     */
    List<RolePermissionVo> findAllPermissionswithAvailable();

    /**
     * 查找出所有与本角色关联的权限的id
     * @param id
     * @return
     */
    List<Integer> findPermissionsByRoleId(Long id);

    /**
     * 更新角色的权限信息
     * @param roleId
     * @param permissionIds
     */
    void updatePermissions(Long roleId, List<Long> permissionIds);
}
