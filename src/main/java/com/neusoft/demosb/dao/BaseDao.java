package com.neusoft.demosb.dao;

import com.neusoft.demosb.util.MySqlProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;


public interface BaseDao<T> {
//把几个表的增删改放这里
    /**
     * 新增数据
     *
     * @param bean 实例对象
     * @return 影响行数
     */
    @InsertProvider(type = MySqlProvider.class, method = MySqlProvider.INSERT)
    int insert(T bean);
    @DeleteProvider(type = MySqlProvider.class, method = MySqlProvider.DELETE)
    int delete(@Param("table") String table,@Param("where") String where);
    @UpdateProvider(type = MySqlProvider.class, method = MySqlProvider.UPDATE)
    int update(T bean);

}
