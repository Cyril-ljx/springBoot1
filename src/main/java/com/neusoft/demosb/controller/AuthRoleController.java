package com.neusoft.demosb.controller;

import com.neusoft.demosb.entity.AuthRole;
import com.neusoft.demosb.service.AuthRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (AuthRole)表控制层
 *
 * @author makejava
 * @since 2020-06-04 11:28:32
 */
@RestController
@RequestMapping("authRole")
public class AuthRoleController {
    /**
     * 服务对象
     */
    @Resource
    private AuthRoleService authRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AuthRole selectOne(Integer id) {
        return this.authRoleService.queryById(id);
    }

}