package com.dou.xhgj.domain.permission;

/**
 * @Author: Francis Zhuge
 * @Description: 权限类。
 * @Date: Created in 2017/10/15, 15:42
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class Permission {
    //主键
    private Long id;
    //权限标识
    private String permission;
    //权限描述
    private String description;
    //是否可用,如果不可用将不会添加给用户，暂时不使用
    private Boolean available = Boolean.FALSE;

    public Permission() {
    }

    public Permission(String permission, String description) {
        this.permission = permission;
        this.description = description;
    }

    public Permission(String permission, String description, Boolean available) {
        this.permission = permission;
        this.description = description;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission that = (Permission) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}
