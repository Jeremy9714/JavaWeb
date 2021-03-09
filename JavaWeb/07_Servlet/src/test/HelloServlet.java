package test;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

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
        /*ServletConfig类是Servlet程序的配置信息类*/
        //获取Servlet程序的别名Servlet-name的值
        System.out.println("Servlet程序名:" + servletConfig.getServletName());
        //获取初始化参数init-param
        System.out.println("初始化参数username的值为:" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数password的值为:" + servletConfig.getInitParameter("password"));
        //获取ServletContext对象
        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println(servletContext);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //service()方法是专门用来处理请求和响应的
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("HelloServlet被访问了");
        //向下强转为子类以使用getMethod()方法
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //getMethod()方法用于获取请求的方式(GET、POST)
        String method = httpServletRequest.getMethod();
        //根据请求方式的不同，执行不同的操作
        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }
    }
    //get请求的操作
    public void doGet(){
        System.out.println("get操作");
    }
    //post请求的操作
    public void doPost(){
        System.out.println("post操作");
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
