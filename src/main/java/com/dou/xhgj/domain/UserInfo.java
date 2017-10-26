package com.dou.xhgj.domain;

import com.alibaba.fastjson.annotation.JSONField;
import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/10/18, 19:17
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class UserInfo {
    private Long id;
    private String userNo;
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
    @JSONField(name="id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JSONField(name="userNo")
    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    @JSONField(name="username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JSONField(name="areaId")
    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    @JSONField(name="buildingId")
    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    @JSONField(serialize = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JSONField(serialize = false)
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @JSONField(name="locked")
    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    @JSONField(serialize = false)
    public String getCredentialsSalt() {
        return username + salt;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userNo='" + userNo + '\'' +
                ", username='" + username + '\'' +
                ", areaId=" + areaId +
                ", buildingId=" + buildingId +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", locked=" + locked +
                '}';
    }
}
