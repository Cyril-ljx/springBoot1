package com.neusoft.demosb.entity;

import com.neusoft.demosb.annotation.Id;
import com.neusoft.demosb.annotation.Table;

import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2020-06-04 11:28:32
 */
@Table("stu.Role")
public class Role implements Serializable {
    private static final long serialVersionUID = -95570024141545761L;
    @Id
    private Integer id;
    /**
    * 角色名称
    */
    private String name;
    /**
    * 是否启用。1.启用，2停用
    */
    private Integer isAllow;


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

}