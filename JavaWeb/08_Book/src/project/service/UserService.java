package project.service;

import project.bean.User;

/**
 * 业务层的方法
 * @author Chenyang
 * @create 2021-03-15-11:19
 */
public interface UserService {

    //注册用户
    void registerUser(User user);

    //用户登录
    User login(User user);

    //检查用户名是否已存在
    boolean existedUsername(String username);

}
