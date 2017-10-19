package com.dou.xhgj.domain;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/10/18, 19:17
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class UserInfo {
    private Long id;
    private String username;
    private Long areaId;
    private Long buildingId;
    private String password;
    private String salt;
    //是否锁定，默认锁定
    private Boolean locked = Boolean.TRUE;

    public UserInfo() {
    }

    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserInfo(String username, Long areaId, Long buildingId, String password, String salt, Boolean locked) {
        this.username = username;
        this.areaId = areaId;
        this.buildingId = buildingId;
        this.password = password;
        this.salt = salt;
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

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getCredentialsSalt() {
        return username + salt;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", areaId='" + areaId + '\'' +
                ", buildingId='" + buildingId + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", locked=" + locked +
                '}';
    }
}
