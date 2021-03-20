package project.web; /**
 * @author Chenyang
 * @create 2021-03-15-16:03
 */

import project.bean.User;
import project.service.UserService;
import project.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //检查验证码是否正确
        if ("abcde".equalsIgnoreCase(code)) {
            /*验证码输入正确*/
            //验证用户名是否可用
            boolean isExisted = userService.existedUsername(username);
            if (!isExisted) {
                /*注册用户*/
                userService.registerUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            } else {
                /*用户名已存在*/
                System.out.println("用户名[" + username + "]已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }
        } else {
            /*验证码输入错误*/
            System.out.println("验证码[" + code + "]输入错误");
            //返回注册页面
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }

    }
}
