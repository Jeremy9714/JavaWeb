package project.test;

import org.junit.Test;
import project.bean.User;
import project.service.UserService;
import project.service.impl.UserServiceImpl;

import static org.junit.Assert.*;

/**
 * @author Chenyang
 * @create 2021-03-15-11:37
 */
public class UserServiceImplTest {

    private UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null, "user_2", "qwe123", "user2@gmai.com"));
    }

    @Test
    public void login() {
        User user = userService.login(new User(null, "admin", "admin", null));
        if (user != null) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }

    @Test
    public void existedUsername() {
        boolean isExisted = userService.existedUsername("user_3");
        if (isExisted) {
            System.out.println("该用户名已存在");
        }else{
            System.out.println("用户名可用");
        }
    }
}