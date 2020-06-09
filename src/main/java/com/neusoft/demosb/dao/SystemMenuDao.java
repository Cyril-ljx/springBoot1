package com.neusoft.demosb.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neusoft.demosb.entity.SystemMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统菜单表(SystemMenu)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-27 15:56:18
 */
@Mapper
@Repository
public interface SystemMenuDao extends BaseDao<SystemMenu> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SystemMenu queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    List<SystemMenu> queryAllByLimit(IPage<SystemMenu> page, SystemMenu bean);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param systemMenu 实例对象
     * @return 对象列表
     */
    List<SystemMenu> queryAll(SystemMenu systemMenu);

}