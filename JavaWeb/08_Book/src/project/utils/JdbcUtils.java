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
 * @author Chenyang
 * @create 2021-03-11-10:36
 */
public class JdbcUtils {
    private static DruidDataSource druid;

    static{
        try {
            Properties prop = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            prop.load(is);
            druid = (DruidDataSource) DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        DruidPooledConnection connect = null;
        try {
            connect = druid.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connect;
    }

    public static void closeResource(Connection connect){
        try {
            DbUtils.close(connect);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
