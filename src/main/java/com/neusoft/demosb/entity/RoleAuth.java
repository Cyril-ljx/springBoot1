package com.neusoft.demosb.entity;

import com.neusoft.demosb.annotation.Id;
import com.neusoft.demosb.annotation.Table;

import java.io.Serializable;

/**
 * (RoleAuth)实体类
 *
 * @author makejava
 * @since 2020-06-04 09:19:07
 */
@Table("stu.role_auth")
public class RoleAuth implements Serializable {

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