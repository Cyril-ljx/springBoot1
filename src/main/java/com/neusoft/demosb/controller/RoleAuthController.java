package com.neusoft.demosb.controller;

import com.neusoft.demosb.entity.RoleAuth;
import com.neusoft.demosb.service.RoleAuthService;
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
public class RoleAuthController {
    /**
     * 服务对象
     */
    @Resource
    private RoleAuthService roleAuthService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RoleAuth selectOne(Integer id) {
        return this.roleAuthService.queryById(id);
    }

}