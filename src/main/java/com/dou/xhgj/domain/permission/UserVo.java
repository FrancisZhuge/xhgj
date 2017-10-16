package com.dou.xhgj.domain.permission;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/10/16, 9:51
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class UserVo {
    private Long id;
    private String username;
    private Boolean locked;

    public UserVo() {
    }

    public UserVo(Long id, String username, Boolean locked) {
        this.id = id;
        this.username = username;
        this.locked = locked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", locked=" + locked +
                '}';
    }
}
