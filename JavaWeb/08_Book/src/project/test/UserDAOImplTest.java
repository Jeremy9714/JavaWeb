package project.test;

import org.junit.Test;
import project.dao.impl.UserDAOImpl;
import project.bean.User;

/**
 * @author Chenyang
 * @create 2021-03-15-11:03
 */
public class UserDAOImplTest {

    private UserDAOImpl test = new UserDAOImpl();

    @Test
    public void queryUserByUsername() {
        User user = test.queryUserByUsername("admin");
        if (user == null) {
            System.out.println("用户名可用");
        } else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void queryUserViaUsernameAndPassword() {
        User user = test.queryUserByUsernameAndPassword("user_1", "abc123");
        if (user == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void registerUser() {
        int count = test.registerUser(new User(100, "user_1", "abc123", "user1@gmail.com"));
        if (count == -1) {
            System.out.println("用户已存在");
        } else {
            System.out.println("注册成功");
        }
    }
}