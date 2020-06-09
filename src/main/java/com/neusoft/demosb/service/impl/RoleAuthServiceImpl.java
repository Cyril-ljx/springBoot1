package com.neusoft.demosb.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.demosb.dao.RoleAuthDao;
import com.neusoft.demosb.entity.RoleAuth;
import com.neusoft.demosb.service.RoleAuthService;
import com.neusoft.demosb.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (RoleAuth)表服务实现类
 *
 * @author makejava
 * @since 2020-06-04 09:19:07
 */
@Service("roleAuthService")
public class RoleAuthServiceImpl implements RoleAuthService {
    @Autowired
    private RoleAuthDao roleAuthDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RoleAuth queryById(Integer id) {
        return this.roleAuthDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public IPage<RoleAuth> queryAllByLimit(int offset, int limit, RoleAuth bean) {
        Page<RoleAuth> page = new Page<>(offset, limit);

        page.setRecords(roleAuthDao.queryAllByLimit(page, bean));

        return page;
    }

    /**
     * 新增数据
     *
     * @param roleAuth 实例对象
     * @return 实例对象
     */
    @Override
    public RoleAuth insert(RoleAuth roleAuth) {
        this.roleAuthDao.insert(roleAuth);
        return roleAuth;
    }

    /**
     * 修改数据
     *
     * @param roleAuth 实例对象
     * @return 实例对象
     */
    @Override
    public RoleAuth update(RoleAuth roleAuth) {
        this.roleAuthDao.update(roleAuth);
        return this.queryById(roleAuth.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @return 是否成功
     */
    @Override
    public boolean deleteById(List<Integer> ids) {
        return this.roleAuthDao.delete("stu.role_auth", StringUtil.listToString(ids)) > 0;
    }
}