package com.neusoft.demosb.entity;

import com.neusoft.demosb.annotation.Id;
import com.neusoft.demosb.annotation.Table;

import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2020-06-04 09:19:07
 */
@Table("stu.role")
public class Role implements Serializable {

    @Id
    private Integer id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 是否启用：1 启用，0 停用
     */
    private Integer isAllow;

    private String menus;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsAllow() {
        return isAllow;
    }

    public void setIsAllow(Integer isAllow) {
        this.isAllow = isAllow;
    }

    public String getMenus() {
        return menus;
    }

    public void setMenus(String menus) {
        this.menus = menus;
    }
}