package test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Chenyang
 * @create 2021-03-10-10:26
 */
public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getRequestURI(): 获取请求的资源路径
        System.out.println("请求的资源路径 " + req.getRequestURI());

        //getRequestURL(): 获取请求的统一资源定位符(绝对路径)
        System.out.println("请求的绝对路径: " + req.getRequestURL());

        //getRemoteHost(): 获取客户端的ip地址
        /*
        * 在IDEA中，使用localhost(域)访问时，得到的客户端ip地址是: 127.0.0.1
        * 在IDEA中，使用127.0.0.1(loopback)访问时，得到的客户端ip地址是: 127.0.0.1
        * 在IDEA中，使用真实ip访问时，得到的客户端ip地址是: 真实ip地址
        * */
        System.out.println("客户端ip地址: " + req.getRemoteHost());

        //getHeader(String): 获取请求头
        System.out.println("请求头Host: " + req.getHeader("Host"));

        //getMethod(): 获取请求方式
        System.out.println("请求方式: " + req.getMethod());
    }
}
