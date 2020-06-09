package com.neusoft.demosb.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neusoft.demosb.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * (Role)表服务接口
 *
 * @author makejava
 * @since 2020-06-04 09:19:07
 */
public interface RoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Role queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    IPage<Role> queryAllByLimit(int offset, int limit, Role bean);


    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    int insert(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    int update(Role role);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(List<Integer> id);

    List<Map<String, Object>> getAuth(String menus);

}