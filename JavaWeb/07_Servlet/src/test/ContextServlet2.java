package test; /**
 * @author Chenyang
 * @create 2021-03-09-18:38
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet方法");
        //获取ServletContext对象
        ServletContext servletContext = getServletContext();

        //保存之前，值为null
        System.out.println("保存之前，ServletContext中key1的值是: " + servletContext.getAttribute("key1"));
        //存取数据，直到工程结束前，在ServletContext中存储的数据可以在web工程中的任意地方访问
        servletContext.setAttribute("key1", "value1");
        System.out.println("ServletContext中key1的值是: " + servletContext.getAttribute("key1"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
