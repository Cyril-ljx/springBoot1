package com.neusoft.demosb.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.demosb.dao.RoleDao;
import com.neusoft.demosb.entity.Role;
import com.neusoft.demosb.service.RoleService;
import com.neusoft.demosb.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Role)表服务实现类
 *
 * @author makejava
 * @since 2020-06-04 09:19:07
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private RoleDao roleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Role queryById(Integer id) {
        return this.roleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public IPage<Role> queryAllByLimit(int offset, int limit, Role bean) {
        Page<Role> page = new Page<>(offset, limit);

        page.setRecords(roleDao.queryAllByLimit(page, bean));

        return page;
    }

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Role role) {
        return this.roleDao.insert(role);
    }

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Role role) {
        return this.roleDao.update(role);
    }

    /**
     * 通过主键删除数据
     *
     * @return 是否成功
     */
    @Override
    public boolean deleteById(List<Integer> ids) {
        return this.roleDao.delete("stu.role", StringUtil.listToString(ids)) > 0;
    }

    @Override
    public List<Map<String, Object>> getAuth(String menus) {
        return roleDao.getAuth(menus);
    }
}