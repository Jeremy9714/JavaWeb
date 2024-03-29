package project.dao.impl;

import project.bean.User;
import project.dao.UserDAO;
import project.utils.JdbcUtils;

import java.sql.Connection;

/**
 * @author Chenyang
 * @create 2021-03-15-10:54
 */
public class UserDAOImpl extends BaseDAO<User> implements UserDAO {

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select id, username, password, email from t_user where username = ?";
        return queryForOne(sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id, username, password, email from t_user where username = ? and password = ?";
        return queryForOne(sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username, password, email) values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
