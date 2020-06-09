package com.neusoft.demosb.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neusoft.demosb.entity.Role;
import com.neusoft.demosb.entity.common.CommonResult;
import com.neusoft.demosb.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * (Role)表控制层
 *
 * @author makejava
 * @since 2020-06-04 09:19:07
 */
@Controller
@RequestMapping("role")
public class RoleController {
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;

    @RequestMapping("toList")
    public String toList() {
        return "menu/role_list";
    }

    @RequestMapping("toAuthList/{id}")
    public String toAuthList(@PathVariable Integer id, Model model) {
        model.addAttribute("role", roleService.queryById(id));

        return "menu/role_auth_list";
    }

    @PostMapping("queryMenus")
    @ResponseBody
    public Object queryMenus(String menus) {
        System.out.println(menus);
        return roleService.getAuth(menus);
    }

    @GetMapping("/")
    public String toAdd(Model model) {
        model.addAttribute("bean", new Role());

        return "menu/role_add";
    }

    @GetMapping("/{id}")
    public String toEdit(@PathVariable Integer id, Model model) {
        System.out.println("id:::" + id);
        Role bean = roleService.queryById(id);
        model.addAttribute("bean", bean);

        return "menu/role_add";
    }

    @PostMapping("save")
    @ResponseBody
    public Object save(Role bean) {
        boolean result = false;
        //判断账号是否存在

        //判断是添加还是编辑
        if (bean.getId() != null) {
            //编辑
            result = roleService.update(bean) > 0;
        } else {
            //添加
            result = roleService.insert(bean) > 0;
        }

        return result;
    }

    @PostMapping("queryAll")
    @ResponseBody
    public Object queryAll(Integer page, Integer limit, Role bean) {
        System.out.println(bean);
        CommonResult<Role> result = new CommonResult<>();
        IPage<Role> iPage = roleService.queryAllByLimit(page, limit, bean);
        result.setCode(0);
        result.setCount(iPage.getTotal());
        result.setData(iPage.getRecords());
        return result;
    }

    @DeleteMapping("/{ids}")
    @ResponseBody
    public boolean deleteById(@PathVariable Integer[] ids) {
        if (ids == null || ids.length == 0) {
            return false;
        }
        roleService.deleteById(Arrays.asList(ids));
        return true;
    }

}