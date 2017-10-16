package com.dou.xhgj.domain.permission;

/**
 * @Author: Francis Zhuge
 * @Description: 角色权限类
 * @Date: Created in 2017/10/16, 9:46
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class RolePermission {
    private Long roleId;
    private Long permissionId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolePermission that = (RolePermission) o;

        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        return permissionId != null ? permissionId.equals(that.permissionId) : that.permissionId == null;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (permissionId != null ? permissionId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "roleId=" + roleId +
                ", permissionId=" + permissionId +
                '}';
    }
}
