package com.neusoft.demosb.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neusoft.demosb.entity.RoleAuth;

import java.util.List;

/**
 * (RoleAuth)表服务接口
 *
 * @author makejava
 * @since 2020-06-04 09:19:07
 */
public interface RoleAuthService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoleAuth queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    IPage<RoleAuth> queryAllByLimit(int offset, int limit, RoleAuth bean);

    /**
     * 新增数据
     *
     * @param roleAuth 实例对象
     * @return 实例对象
     */
    RoleAuth insert(RoleAuth roleAuth);

    /**
     * 修改数据
     *
     * @param roleAuth 实例对象
     * @return 实例对象
     */
    RoleAuth update(RoleAuth roleAuth);

    /**
     * 通过主键删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    boolean deleteById(List<Integer> ids);

}