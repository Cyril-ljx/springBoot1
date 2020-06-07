package com.neusoft.demosb.service;

import com.neusoft.demosb.entity.AuthRole;

import java.util.List;



/**
 * (AuthRole)表服务接口
 *
 * @author makejava
 * @since 2020-06-04 11:28:31
 */
public interface AuthRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthRole queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AuthRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    AuthRole insert(AuthRole authRole);

    /**
     * 修改数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    AuthRole update(AuthRole authRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}