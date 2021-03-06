package com.neusoft.demosb.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neusoft.demosb.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Student)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-29 17:26:00
 */
@Mapper
@Repository
public interface StudentDao extends BaseDao<Student> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Student queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Student> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bean 实例对象
     * @return 对象列表
     */
    List<Student> queryAll(IPage<Student> page, Student bean);


    int insertBatch(@Param("list") List<Student> list);
}