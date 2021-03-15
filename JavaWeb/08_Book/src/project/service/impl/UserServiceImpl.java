package project.service.impl;

import project.bean.User;
import project.dao.UserDAO;
import project.dao.impl.UserDAOImpl;
import project.service.UserService;

/**
 * @author Chenyang
 * @create 2021-03-15-11:29
 */
public class UserServiceImpl implements UserService {

    private UserDAO dao = new UserDAOImpl();

    @Override
    public void registerUser(User user) {
        int count = dao.saveUser(user);
        if (count==-1){
            System.out.println("注册失败");
        }else{
            System.out.println("注册成功");
        }
    }

    @Override
    public User login(User user) {
        return dao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existedUsername(String username) {
        return dao.queryUserByUsername(username)!=null;
    }
}
