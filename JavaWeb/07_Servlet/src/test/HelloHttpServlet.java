package test;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Chenyang
 * @create 2021-03-09-12:48
 */
public class HelloHttpServlet extends HttpServlet {
    public HelloHttpServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloHttpServlet的doGet方法");
        //通过getServletConfig()方法获取ServletConfig对象
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloHttpServlet的doPost方法");
    }
}
