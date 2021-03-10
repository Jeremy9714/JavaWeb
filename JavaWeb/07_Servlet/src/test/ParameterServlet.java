package test;
/**
 * 获取请求的参数值
 * @author Chenyang
 * @create 2021-03-10-11:13
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;

public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getParameter(String): 获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //getParameterValues(String): 获取请求的参数(含有多个参数值时)
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println("用户名: " + username);
        System.out.println("密码: " + password);
        System.out.println("爱好: " + Arrays.asList(hobbies));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
