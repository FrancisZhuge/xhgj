package com.dou.xhgj.domain.permission;

/**
 * @Author: Francis Zhuge
 * @Description: 角色权限展示类
 * @Date: Created in 2017/10/16, 9:48
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class RolePermissionVo {
    private int id;
    private String permission;
    private String description;
    //默认没有被选中
    private boolean selected=Boolean.FALSE;

    public RolePermissionVo() {
    }

    public RolePermissionVo(int id, String permission, String description, boolean selected) {
        this.id = id;
        this.permission = permission;
        this.description = description;
        this.selected = selected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "RolePermissionVo{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                ", description='" + description + '\'' +
                ", selected=" + selected +
                '}';
    }
}
