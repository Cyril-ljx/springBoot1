package com.neusoft.demosb.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neusoft.demosb.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Admin)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-25 16:58:13
 */
@Mapper
@Repository
public interface AdminDao extends BaseDao<Admin>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Admin queryById(Integer id);

    Admin login(@Param("account") String account, @Param("password") String password);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Admin> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit, Admin bean);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param bean 实例对象
     * @return 对象列表
     */
    List<Admin> queryAll(IPage<Admin> page, Admin bean);

}