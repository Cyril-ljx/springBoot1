package com.neusoft.demosb.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.demosb.dao.SystemMenuDao;
import com.neusoft.demosb.entity.MenuVo;
import com.neusoft.demosb.entity.SystemMenu;
import com.neusoft.demosb.service.SystemMenuService;
import com.neusoft.demosb.util.StringUtil;
import com.neusoft.demosb.util.TreeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, Object> queryAll() {
        Map<String, Object> map = new HashMap<>(16);
        Map<String,Object> home = new HashMap<>(16);
        Map<String,Object> logo = new HashMap<>(16);
        List<SystemMenu> menuList = systemMenuDao.queryAll(null);
        List<MenuVo> menuInfo = new ArrayList<>();
        for (SystemMenu e : menuList) {
            MenuVo menuVO = new MenuVo();
            menuVO.setId(e.getId());
            menuVO.setPid(e.getPid());
            menuVO.setHref(e.getHref());
            menuVO.setTitle(e.getTitle());
            menuVO.setIcon(e.getIcon());
            menuVO.setTarget(e.getTarget());
            menuInfo.add(menuVO);
        }
        map.put("menuInfo", TreeUtil.toTree(menuInfo, 0));
        home.put("title","首页");
        home.put("href","/page/welcome-1");//控制器路由,自行定义
        logo.put("title","后台管理系统");
        logo.put("image","/static/images/back.jpg");//静态资源文件路径,可使用默认的logo.png
        map.put("homeInfo", "{title: '首页',href: '/ruge-web-admin/page/welcome.html'}}");
        map.put("logoInfo", "{title: 'RUGE ADMIN',image: 'images/logo.png'}");
        return map;
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
        return systemMenuDao.update(systemMenu)>0;

    }

    /**
     * 通过主键删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(List<Integer> ids) {//有隐患，不能防止sql注入攻击

        if(ids==null||ids.size()==0){
            return false;
        }

        return systemMenuDao.delete("stu.system_menu", StringUtil.listToString(ids))>0;
    }
}