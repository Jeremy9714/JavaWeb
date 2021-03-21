package project.web; /**
 * @author Chenyang
 * @create 2021-03-15-17:50
 */

import project.bean.User;
import project.service.UserService;
import project.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //判断用户名与密码是否正确
        User loginUser = userService.login(new User(null, username, password, null));
        //不正确则返回登录页面
        if (loginUser == null) {
            //把错误信息，和回显的表单项保存到Request域中
            req.setAttribute("msg", "用户名或密码不正确");
            req.setAttribute("username", username);

            System.out.println("用户名或密码不正确");

            //跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            //成功登陆
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }
}