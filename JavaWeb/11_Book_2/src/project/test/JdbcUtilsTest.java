package project.test;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.junit.Test;
import project.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author Chenyang
 * @create 2021-03-15-10:00
 */
public class JdbcUtilsTest {

    @Test
    public void testConnection() throws SQLException {
//        Connection connect = JdbcUtils.getConnection();
//        //System.out.println(connect);
//
//        QueryRunner runner = new QueryRunner();
//        String sql = "select id, username, password, email from t_user";
//        MapHandler handler = new MapHandler();
//        Map<String, Object> map = runner.query(connect, sql, handler);
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//        JdbcUtils.commitAndClose();
    }

}
