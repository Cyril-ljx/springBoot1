package com.neusoft.demosb.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.demosb.dao.StudentDao;
import com.neusoft.demosb.entity.Student;
import com.neusoft.demosb.service.StudentService;
import com.neusoft.demosb.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Student)表服务实现类
 *
 * @author makejava
 * @since 2020-05-29 17:26:00
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Student queryById(Integer id) {
        return this.studentDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Student> queryAllByLimit(int offset, int limit) {
        return this.studentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student insert(Student student) {
        this.studentDao.insert(student);
        return student;
    }

    @Override
    public int insert(List<Student> list) {
        return studentDao.insertBatch(list);
    }

    @Override
    public IPage<Student> queryAllByLimit(int offset, int limit, Student bean) {
        Page<Student> page = new Page<>(offset, limit);


        page.setRecords(studentDao.queryAll(page, bean));

        return page;
    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Student student) {
        return  this.studentDao.update(student);
    }

    /**
     * 通过主键删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(List<Integer> ids) {
        System.out.println(ids);

        return studentDao.delete("stu.student", StringUtil.listToString(ids))>0;
    }
}