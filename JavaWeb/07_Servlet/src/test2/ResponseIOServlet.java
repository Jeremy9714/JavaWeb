package test2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Chenyang
 * @create 2021-03-10-16:52
 */
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(resp.getCharacterEncoding());//默认字符集为ISO-8859-1
//        //设置服务器字符集
//        resp.setCharacterEncoding("UTF-8");
//
//        //通过响应头，设置浏览器也使用相同的字符集(UTF-8)
//        resp.setHeader("Content-Type","text/html; charset=UTF-8");

        //同时设置服务器和客户端都使用UTF-8，并设置响应头
        resp.setContentType("text/html; charset=UTF-8");
        System.out.println(resp.getCharacterEncoding());

        //可以通过流的方式向客户端回传数据
        PrintWriter writer = resp.getWriter();
        writer.write("返回给客户端的信息");
    }
}
