package com.neusoft.demosb.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neusoft.demosb.entity.Admin;
import com.neusoft.demosb.entity.AdminQuery;
import com.neusoft.demosb.entity.common.CommonResult;
import com.neusoft.demosb.service.AdminService;
import com.neusoft.demosb.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2020-05-25 16:58:15
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    private Logger logger= LoggerFactory.getLogger(getClass());
    /**
     * 服务对象
     */
    @Resource//@Autowire
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("toLogin")
    public String toLogin() {
        logger.trace("trace是低级别");
        logger.debug("老二");
        logger.info("老三");
        logger.warn("老四");
        logger.error("老五");
        return "login";
    }

    @RequestMapping("toWelcome")
    public String toWelcome() {
        return "welcome";
    }

    @RequestMapping("toList")
    public String toList() {
        return "user/admin_list";
    }

    //@RequestMapping("/")
    @RequestMapping("toAdd")
    public String toAdd(Model model) {
        model.addAttribute("bean", new Admin());

        return "user/admin_add";
    }

    @RequestMapping("toEdit")
    public String toEdit(Integer id, Model model) {
        System.out.println("id:::" + id);
        Admin bean = adminService.queryById(id);
        model.addAttribute("bean", bean);

        return "user/admin_add";
    }



    @PostMapping("save")
    @ResponseBody
    public Object save(Admin bean) {
        boolean result = false;
        //判断账号是否存在

        //判断是添加还是编辑
        if (bean.getId() != null) {
            //编辑
            result = adminService.update(bean) > 0;
        } else {
            //添加
            bean.setRegDate(new Date());
            result = adminService.insert(bean).getId() != null;
        }

        return result;
    }

    @PostMapping("queryAll")
    @ResponseBody
    public Object queryAll(Integer page, Integer limit, AdminQuery bean) {
        System.out.println(bean);
        CommonResult<Admin> result = new CommonResult<>();
        IPage<Admin> iPage = adminService.queryAllByLimit(page, limit, bean);
        result.setCode(0);
        result.setCount(iPage.getTotal());
        result.setData(iPage.getRecords());
        return result;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     *
     */
    @GetMapping("getById")
    @ResponseBody
    public Admin getById(Integer id) {
        return this.adminService.queryById(id);
    }

    @PostMapping("login")
    public String login(String account, String password, Model model, HttpServletRequest request) {
        HttpSession session=request.getSession();
        Admin admin = adminService.login(account, password);
        if (admin == null) {
            //登录不成功
            session.invalidate();
            model.addAttribute("msg", "账号或密码错误");
            return "login";
        }
        else{
            //使用Cookie记住账号和密码
            //将用户信息存入到session
            session.setAttribute("account",account);
            return "index";

        }

    }

//    @RequestMapping("toIndex")
//    public String toIndex() {
//        return "index";
//    }

    @PostMapping("insert")
    @ResponseBody
    public Admin insert(Admin bean) {
        return adminService.insert(bean);
    }

    @PostMapping("deleteById")
    @ResponseBody
    public boolean deleteById(Integer[] ids) {
        if (ids == null || ids.length == 0) {
            return false;
        }
        adminService.deleteById(Arrays.asList(ids));
        return true;
    }
}