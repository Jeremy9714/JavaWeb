package test; /**
 * @author Chenyang
 * @create 2021-03-10-12:19
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String username = req.getParameter("username");
        System.out.println("在Servlet1中查看参数 " + username);

        //标记已完成，并传递到下一个Servlet中查看
        req.setAttribute("key","Servlet1已完成任务");

        //请求转发
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
//        //请求转发可以转发到WEB-INF目录下
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/form.html");

        //转发至目标对象
        requestDispatcher.forward(req,resp);

    }

}
