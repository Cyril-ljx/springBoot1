package com.neusoft.demosb.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neusoft.demosb.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * (Role)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-04 09:19:07
 */
@Mapper
@Repository
public interface RoleDao extends BaseDao<Role> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Role queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param bean 查询起始位置
     * @param page 查询条数
     * @return 对象列表
     */
    List<Role> queryAllByLimit(IPage<Role> page, Role bean);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param role 实例对象
     * @return 对象列表
     */
    List<Role> queryAll(Role role);

    List<Map<String, Object>> getAuth(@Param("menus") String menus);
}