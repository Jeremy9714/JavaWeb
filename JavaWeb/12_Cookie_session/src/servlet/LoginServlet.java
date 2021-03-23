package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Chenyang
 * @create 2021-03-23-16:31
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //登录成功
        if ("abc".equals(username) && "123".equals(password)) {
            System.out.println("登陆成功");
            //创建Cookie保存成功登陆的用户名
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60);
            resp.addCookie(cookie);
        } else {
            System.out.println("登录失败");
        }
    }
}
