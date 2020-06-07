package com.neusoft.demosb.entity;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 16:19 2020/5/29
 */
public class StudentExcel {
    @ExcelProperty("学号")
    private String code;//学号
    @ExcelProperty("姓名")
    private String name;//姓名
    @ExcelProperty("班级")
    private String className;//班级
    @ExcelProperty("备注")
    private String remark;//备注

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "StudentExcel{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
