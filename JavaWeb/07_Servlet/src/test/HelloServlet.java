package test;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Chenyang
 * @create 2021-03-08-21:55
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("构造器方法调用");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init方法调用");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //service()方法是专门用来处理请求和响应的
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("HelloServlet被访问了");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destory销毁方法调用");
    }
}
