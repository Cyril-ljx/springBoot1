package com.neusoft.demosb.controller;

import com.neusoft.demosb.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 10:37 2020/5/25
 */
@Controller
public class HelloController {

    /**
     * ${}：可以取环境变量中的值，只是取值
     * #{}：字符串做""，数值不加
     */

    @Value("${neu.className}")
    private String className;
    @Value("${neu.count}")
    private int count;
    @Autowired
    private Teacher teacher;

    @RequestMapping("hello")
    @ResponseBody//json格式返回
    public String hello() {
        return "课程名称：" + className + "，上课人数：" + count + "，教师信息：" + teacher + ", hello spring boot";
    }
}
