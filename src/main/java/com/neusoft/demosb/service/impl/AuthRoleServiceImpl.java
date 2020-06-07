package com.neusoft.demosb.service.impl;

import com.neusoft.demosb.dao.AuthRoleDao;
import com.neusoft.demosb.entity.AuthRole;
import com.neusoft.demosb.service.AuthRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * (AuthRole)表服务实现类
 *
 * @author makejava
 * @since 2020-06-04 11:28:32
 */
@Service("authRoleService")
public class AuthRoleServiceImpl implements AuthRoleService {
    @Resource
    private AuthRoleDao authRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AuthRole queryById(Integer id) {
        return this.authRoleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<AuthRole> queryAllByLimit(int offset, int limit) {
        return this.authRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    @Override
    public AuthRole insert(AuthRole authRole) {
        this.authRoleDao.insert(authRole);
        return authRole;
    }

    /**
     * 修改数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    @Override
    public AuthRole update(AuthRole authRole) {
        this.authRoleDao.update(authRole);
        return this.queryById(authRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.authRoleDao.deleteById(id) > 0;
    }
}