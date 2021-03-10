package test2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Chenyang
 * @create 2021-03-10-17:30
 */
public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("已访问response1");
        /*第一种方法*/

//        //重定向不共享Request域的数据
//        req.setAttribute("key","abc");
//
//        //设置相应码，表示重定向
//        resp.setStatus(302);
//
//        //设置响应头，说明新的地址
//        resp.setHeader("Location","http://localhost:8080/07_Servlet/response2");
//
////        //可以访问工程外的资源
////        resp.setHeader("Location","http://www.baidu.com");

        /*第二种方法(推荐)*/
        //sendDirect()方法自动设置响应码和响应头
        resp.sendRedirect("/07_Servlet/response2");
    }
}
