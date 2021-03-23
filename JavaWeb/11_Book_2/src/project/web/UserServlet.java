package project.web;

import org.apache.commons.beanutils.BeanUtils;
import project.bean.User;
import project.service.UserService;
import project.service.impl.UserServiceImpl;
import project.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * 合并的Servlet程序
 *
 * @author Chenyang
 * @create 2021-03-21-13:22
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    //用户登录的功能
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
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
            //保存用户登录后的信息
            req.getSession().setAttribute("user",loginUser);

            //跳转到登录成功页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    //用户注销的功能
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //注销当前Session会话
        req.getSession().invalidate();

        //重定向回首页
        resp.sendRedirect(req.getContextPath());
    }

    //用户注册的功能
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //获取请求参数
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //将请求的参数注入JavaBean中
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        //检查验证码是否输入正确
        if (token!=null && token.equalsIgnoreCase(code)) {
            //验证用户名是否可用
            boolean isExisted = userService.existedUsername(username);
            if (!isExisted) {
                //注册用户
                userService.registerUser(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            } else {
                //用户名已存在
                System.out.println("用户名[" + username + "]已存在");

                //把错误信息，和回显的表单项保存到Request域中
                req.setAttribute("msg", "该用户名已存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

                //跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }
        } else {
            //验证码输入错误
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
