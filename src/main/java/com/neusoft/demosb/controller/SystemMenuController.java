package com.neusoft.demosb.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neusoft.demosb.entity.SystemMenu;
import com.neusoft.demosb.entity.common.CommonResult;
import com.neusoft.demosb.service.SystemMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;

/**
 * 系统菜单表(SystemMenu)表控制层
 *
 * @author makejava
 * @since 2020-05-27 15:56:18
 */
@Controller
@RequestMapping("systemMenu")
public class SystemMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SystemMenuService systemMenuService;

    @RequestMapping("toList")
    public String toList() {
        return "menu/menu_list";
    }


    @GetMapping("menus")
    @ResponseBody
    public Map<String, Object> menus() {

        return systemMenuService.queryAll();
    }
    @GetMapping("/")
    public String toAdd(Model model) {
        model.addAttribute("bean", new SystemMenu());

        return "menu/menu_add";
    }

    @GetMapping("/{id}")
    public String toEdit(@PathVariable Integer id, Model model) {
        System.out.println("id:::" + id);
        SystemMenu bean = systemMenuService.queryById(id);
        model.addAttribute("bean", bean);

        return "menu/menu_add";
    }



    @PostMapping("save")
    @ResponseBody
    public Object save(SystemMenu bean) {
        boolean result = false;
        //判断账号是否存在

        //判断是添加还是编辑
        if (bean.getId() != null) {
            //编辑
            result = systemMenuService.update(bean);
        } else {
            //添加
            result = systemMenuService.insert(bean).getId() != null;
        }

        return result;
    }

    @PostMapping("queryAll")
    @ResponseBody
    public Object queryAll(Integer page, Integer limit, SystemMenu bean) {
        System.out.println(bean);
        CommonResult<SystemMenu> result = new CommonResult<>();
        IPage<SystemMenu> iPage = systemMenuService.queryAllByLimit(page, limit,bean);
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
        return systemMenuService.deleteById(Arrays.asList(ids));

    }
}