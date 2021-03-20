package project.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import project.utils.JdbcUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Chenyang
 * @create 2021-03-15-10:24
 */
public abstract class BaseDAO<T> {

    private QueryRunner runner = new QueryRunner();
    private Class<T> type = null;

    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] types = parameterizedType.getActualTypeArguments();
        type = (Class<T>) types[0];
    }

    //通用的增删改操作
    public int update(Connection connect, String sql, Object... args) {
        try {
            return runner.update(connect, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.closeResource(connect);
        }
        //操作失败，则返回-1
        return -1;
    }

    //查询表中一条数据
    public T queryForOne(Connection connect, String sql, Object... args) {
        try {
            return runner.query(connect, sql, new BeanHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.closeResource(connect);
        }
        return null;
    }

    //查询表中多条数据
    public List<T> queryForList(Connection connect, String sql, Object... args) {
        try {
            return runner.query(connect, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.closeResource(connect);
        }
        return null;
    }

    //查询表中特殊数值
    public <E> E queryForValue(Connection connect, String sql, Object... args) {
        try {
            return (E) runner.query(connect, sql, new ScalarHandler(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
