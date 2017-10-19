package com.dou.xhgj.domain.permission;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/10/19, 17:08
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class UserRoleVo {
    private int id;
    private String role;
    private String description;
    //默认没有被选中
    private boolean selected=Boolean.FALSE;

    public UserRoleVo() {
    }

    public UserRoleVo(int id, String role, String description, boolean selected) {
        this.id = id;
        this.role = role;
        this.description = description;
        this.selected = selected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        return "UserRoleVo{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", selected=" + selected +
                '}';
    }
}
