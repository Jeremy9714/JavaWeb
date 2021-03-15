package project.dao.impl;

import project.dao.UserDAO;
import project.bean.User;
import project.utils.JdbcUtils;

import java.sql.Connection;

/**
 * @author Chenyang
 * @create 2021-03-15-10:54
 */
public class UserDAOImpl extends BaseDAO<User> implements UserDAO {

    @Override
    public User queryUserByUsername(String username) {
        Connection connect = JdbcUtils.getConnection();
        String sql = "select id, username, password, email from t_user where username = ?";
        return queryForOne(connect, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        Connection connect = JdbcUtils.getConnection();
        String sql = "select id, username, password, email from t_user where username = ? and password = ?";
        return queryForOne(connect, sql, username, password);
    }

    @Override
    public int registerUser(User user) {
        Connection connect = JdbcUtils.getConnection();
        String sql = "insert into t_user(username, password, email) values(?,?,?)";
        return update(connect, sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
