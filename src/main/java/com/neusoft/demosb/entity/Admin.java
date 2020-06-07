package com.neusoft.demosb.entity;

import com.neusoft.demosb.annotation.Id;
import com.neusoft.demosb.annotation.Table;

import java.util.Date;
import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2020-05-25 16:57:37
 */
@Table("stu.admin")
public class Admin implements Serializable {
    @Id
    private Integer id;
    /**
    * 账号
    */
    private String account;
    /**
    * 密码
    */
    private String password;
    /**
    * 手机号
    */
    private String mobile;
    /**
    * 注册时间
    */
    private Date regDate;
    /**
    * 最后一次登录
    */
    private Date lastLoginDate;
    /**
    * 是否启用，1 启用，0 停用
    */
    private Integer isAllow;

    private String roles;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Integer getIsAllow() {
        return isAllow;
    }

    public void setIsAllow(Integer isAllow) {
        this.isAllow = isAllow;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", regDate=" + regDate +
                ", lastLoginDate=" + lastLoginDate +
                ", isAllow=" + isAllow +
                ", roles='" + roles + '\'' +
                '}';
    }
}