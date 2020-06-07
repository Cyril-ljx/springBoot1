package com.neusoft.demosb.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.demosb.entity.Admin;
import com.neusoft.demosb.entity.AdminQuery;

import java.util.List;

/**
 * (Admin)表服务接口
 *
 * @author makejava
 * @since 2020-05-25 16:58:14
 */
public interface AdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Admin queryById(Integer id);

    Admin login(String account, String password);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    IPage<Admin> queryAllByLimit(int offset, int limit, AdminQuery bean);

    List<Admin> queryAll(AdminQuery bean);

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin insert(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    int update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(List<Integer> id);

}