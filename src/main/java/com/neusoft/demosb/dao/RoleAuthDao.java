package com.neusoft.demosb.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neusoft.demosb.entity.RoleAuth;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (RoleAuth)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-04 09:19:07
 */
@Mapper
@Repository
public interface RoleAuthDao extends BaseDao<RoleAuth>{

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoleAuth queryById(Integer id);

    /**
     * 查询指定行数据
     *

     * @param page 查询条数
     * @return 对象列表
     */
    List<RoleAuth> queryAllByLimit(IPage<RoleAuth> page, RoleAuth bean);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param roleAuth 实例对象
     * @return 对象列表
     */
    List<RoleAuth> queryAll(RoleAuth roleAuth);

}