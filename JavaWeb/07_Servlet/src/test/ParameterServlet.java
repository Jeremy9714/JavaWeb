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
        System.out.println("-----------doget------------");
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求体的字符集为UTF-8,解决post请求的中文乱码问题
        //此方法在获取请求参数前调用才有效
        req.setCharacterEncoding("UTF-8");
        System.out.println("-----------dopost------------");
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println("用户名: " + username);
        System.out.println("密码: " + password);
        System.out.println("爱好: " + Arrays.asList(hobbies));
    }
}
