package com.neusoft.demosb.entity;

import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2020-05-29 17:26:00
 */
public class Student implements Serializable {

    private Integer id;

    @ExcelProperty("学号")
    private String code;//学号
    @ExcelProperty("姓名")
    private String name;//姓名
    @ExcelProperty("班级")
    private String className;//班级

    @ExcelProperty("备注")
    private String remark;//备注
    /**
    * 班级id
    */
    private Integer classId;
    /**
    * 手机号
    */
    private String mobile;
    /**
    * 性别：1 男，0 女
    */
    private Integer gender;


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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", remark='" + remark + '\'' +
                ", classId=" + classId +
                ", mobile='" + mobile + '\'' +
                ", gender=" + gender +
                '}';
    }
}