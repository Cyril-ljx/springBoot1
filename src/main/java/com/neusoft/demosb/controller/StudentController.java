package com.neusoft.demosb.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neusoft.demosb.entity.Student;
import com.neusoft.demosb.entity.common.CommonResult;
import com.neusoft.demosb.listener.StudentExcelLisener;
import com.neusoft.demosb.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;

/**
 * (Student)表控制层
 *
 * @author makejava
 * @since 2020-05-29 17:26:00
 */
@Controller
@RequestMapping("student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("toList")
    public String toList() {
        return "user/student_list";
    }
    /**
     * 文件上传
     * @param file
     * @return
     */
    //
    //@RequestMapping("toAdd")
    @RequestMapping("/")
    public String toAdd(Model model) {
        model.addAttribute("bean", new Student());

        return "user/student_add";
    }

    @GetMapping("/{id}")
    public String toEdit(@PathVariable Integer id, Model model) {
        System.out.println("id:::" + id);
        Student bean = studentService.queryById(id);
        model.addAttribute("bean", bean);

        return "user/student_add";
    }



    @PostMapping("save")
    @ResponseBody
    public Object save(Student bean) {
        boolean result = false;
        //判断账号是否存在

        //判断是添加还是编辑
        if (bean.getId() != null) {
            //编辑
            result = studentService.update(bean) > 0;
        } else {
            //添加
            result = studentService.insert(bean).getId() != null;
        }

        return result;
    }
    @PostMapping("upload")
    @ResponseBody
    public Object upload(MultipartFile file) {
        CommonResult<String> result = new CommonResult<>();
        try {
            EasyExcel.read(file.getInputStream(), Student.class, new StudentExcelLisener(studentService)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
            result.setMsg("Excel上传出错");
        }
        result.setData(file.getOriginalFilename());
        return result;
    }

    @DeleteMapping("/{ids}")
    @ResponseBody
    public boolean deleteById(@PathVariable Integer[] ids) {
        if (ids == null || ids.length == 0) {
            return false;
        }
        studentService.deleteById(Arrays.asList(ids));
        return true;
    }
    @PostMapping("queryAll")
    @ResponseBody
    public Object queryAll(Integer page, Integer limit, Student bean) {
        System.out.println(bean);
        CommonResult<Student> result = new CommonResult<>();
        IPage<Student> iPage = studentService.queryAllByLimit(page, limit, bean);
        result.setCode(0);
        result.setCount(iPage.getTotal());
        result.setData(iPage.getRecords());
        return result;
    }

}