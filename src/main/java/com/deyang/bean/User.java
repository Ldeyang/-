package com.deyang.bean;

import java.util.List;

/**
 * @author deyang
 * @date 2020/8/19 - 13:44
 */
public class User {
    private Integer id;
    private String xId;
    private String phone;
    private String username;
    private String password;
    private Integer ZT;
    private String ztStr;
    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getxId() {
        return xId;
    }

    public void setxId(String xId) {
        this.xId = xId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getZT() {
        return ZT;
    }

    public void setZT(Integer ZT) {
        this.ZT = ZT;
    }

    public String getZtStr() {
        if(getZT()!=null){
            if(getZT()==0){
                ztStr="可用的";
            }
            if(getZT()==1){
                ztStr="禁用的";
            }
        }
        return ztStr;
    }

    public void setZtStr(String ztStr) {
        this.ztStr = ztStr;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", xId='" + xId + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ZT=" + ZT +
                ", ztStr='" + ztStr + '\'' +
                ", roles=" + roles +
                '}';
    }
}
