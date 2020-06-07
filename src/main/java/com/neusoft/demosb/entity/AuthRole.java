package com.neusoft.demosb.entity;

import com.neusoft.demosb.annotation.Id;
import com.neusoft.demosb.annotation.Table;

import java.io.Serializable;

/**
 * (AuthRole)实体类
 *
 * @author makejava
 * @since 2020-06-04 11:28:27
 */
@Table("stu.AuthRole")
public class AuthRole implements Serializable {
    private static final long serialVersionUID = -59623560438133168L;
    @Id
    private Integer id;
    
    private Integer roleId;
    
    private Integer menuId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

}