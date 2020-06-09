package com.neusoft.demosb.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.demosb.dao.SystemMenuDao;
import com.neusoft.demosb.entity.SystemMenu;
import com.neusoft.demosb.service.SystemMenuService;
import com.neusoft.demosb.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统菜单表(SystemMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-05-27 15:56:18
 */
@Service("systemMenuService")
public class SystemMenuServiceImpl implements SystemMenuService {
    @Resource
    private SystemMenuDao systemMenuDao;

    @Override
    public List<SystemMenu> queryAll() {
        return systemMenuDao.queryAll(null);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SystemMenu queryById(Integer id) {
        return this.systemMenuDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public IPage<SystemMenu> queryAllByLimit(int offset, int limit, SystemMenu bean) {
        Page<SystemMenu> page = new Page<>(offset, limit);

        page.setRecords(systemMenuDao.queryAllByLimit(page, bean));
        return page;
    }

    /**
     * 新增数据
     *
     * @param systemMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SystemMenu insert(SystemMenu systemMenu) {
        systemMenu.setStatus(1);
        systemMenu.setTarget("_self");
        this.systemMenuDao.insert(systemMenu);
        return systemMenu;
    }

    /**
     * 修改数据
     *
     * @param systemMenu 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(SystemMenu systemMenu) {
        return systemMenuDao.update(systemMenu) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param ids
     * @return 是否成功
     */
    @Override
    public boolean deleteById(List<Integer> ids) {
        if (ids == null || ids.size() == 0) {
            return false;
        }

        return systemMenuDao.delete("stu.system_menu", StringUtil.listToString(ids)) > 0;
    }
}