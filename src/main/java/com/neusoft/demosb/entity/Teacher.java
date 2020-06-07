package com.neusoft.demosb.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Arrays;
import java.util.List;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 16:39 2020/5/25
 */
@Component
@ConfigurationProperties(prefix = "neu.teacher")
@Validated
public class Teacher {
//    @Email
//    @Value("${neu.teacher.name}")
    private String name;
    private int age;
    private String[] jineng;//技能

    public String[] getJineng() {
        return jineng;
    }

    public void setJineng(String[] jineng) {
        this.jineng = jineng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", jineng=" + Arrays.toString(jineng) +
                '}';
    }
}
