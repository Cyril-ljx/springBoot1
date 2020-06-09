package com.neusoft.demosb.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neusoft.demosb.entity.SystemMenu;

import java.util.List;

/**
 * 系统菜单表(SystemMenu)表服务接口
 *
 * @author makejava
 * @since 2020-05-27 15:56:18
 */
public interface SystemMenuService {

    List<SystemMenu> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SystemMenu queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    IPage<SystemMenu> queryAllByLimit(int offset, int limit, SystemMenu bean);

    /**
     * 新增数据
     *
     * @param systemMenu 实例对象
     * @return 实例对象
     */
    SystemMenu insert(SystemMenu systemMenu);

    /**
     * 修改数据
     *
     * @param systemMenu 实例对象
     * @return 实例对象
     */
    boolean update(SystemMenu systemMenu);

    /**
     * 通过主键删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    boolean deleteById(List<Integer> ids);

}