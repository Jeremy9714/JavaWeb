package test; /**
 * @author Chenyang
 * @create 2021-03-09-18:07
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext servletContext = getServletConfig().getServletContext();
        System.out.println("上下文参数username的值为: " + servletContext.getInitParameter("username"));
        System.out.println("上下文参数password的值为: " + servletContext.getInitParameter("password"));
        //获取当前的工程路径
        System.out.println(servletContext.getContextPath());
        //获取工程部署后在服务器硬盘上的绝对路径
        System.out.println("工程部署的路径是: " + servletContext.getRealPath("/")); //斜杠表示当前工程路径(web目录)
        System.out.println("工程下test目录的绝对路径是: " + servletContext.getRealPath("/test"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
