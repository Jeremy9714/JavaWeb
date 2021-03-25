package project.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.apache.commons.dbutils.DbUtils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC
 *
 * @author Chenyang
 * @create 2021-03-11-10:36
 */
public class JdbcUtils {
    private static DruidDataSource druid;
    //ThreadLocal对象用来保存执行jdbc操作的Connection连接对象
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();

    static {
        try {
            Properties prop = new Properties();
            //web项目中，src目录下的代码在部署到服务器时，会放入WEB-INF下的classes和lib目录中，这两个目录不是由系统类加载器加载的
            //InputStream is = ClassLoader.getClassLoader().getResourceAsStream("jdbc.properties");
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            prop.load(is);
            druid = (DruidDataSource) DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        //获取保存的连接对象
        Connection connect = conns.get();
        //若该链接对象不存在，则创建新的连接
        if (connect == null) {
            try {
                connect = druid.getConnection();
                //将连接对象保存到threadLocal对象，供后面的jdbc操作使用
                conns.set(connect);
                //关闭自动提交
                connect.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connect;
    }

    //提交并关闭连接
    public static void commitAndClose() {
        Connection connect = conns.get();
        if (connect != null) {//若连接对象不为null，则说明此链接对象之前操作过数据库
            try {
                connect.commit();//提交事务
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connect.close();//关闭连接
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        //必须执行此方法，否则会报错(Tomcat服务器底层使用了线程池技术)
        conns.remove();
    }

    //回滚并关闭连接
    public static void rollbackAndClose() {
        Connection connect = conns.get();
        if (connect != null) {//若连接对象不为null，则说明此链接对象之前操作过数据库
            try {
                connect.rollback();//回滚事务
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connect.close();//关闭连接
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        //必须执行此方法，否则会报错(Tomcat服务器底层使用了线程池技术)
        conns.remove();
    }

//    public static void closeResource(Connection connect) {
//        try {
//            DbUtils.close(connect);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
}
