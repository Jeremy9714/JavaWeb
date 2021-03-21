package project.web;

import project.bean.User;
import project.service.UserService;
import project.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 合并的Servlet程序
 *
 * @author Chenyang
 * @create 2021-03-21-13:22
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    //处理登录的功能
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    //处理注册的功能
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

                //跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }
        } else {
            /*验证码输入错误*/
            System.out.println("验证码[" + code + "]输入错误");

            //把错误信息，和回显的表单项保存到Request域中
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            //返回注册页面
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}
