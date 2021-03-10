package test; /**
 * @author Chenyang
 * @create 2021-03-10-12:19
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String password = req.getParameter("password");
        System.out.println("在Servlet2中查看参数: " + password);

        //检查标记
        Object key = req.getAttribute("key");
        System.out.println("Servlet1的标记：" + key);

        //处理自己的业务
        System.out.println("Servlet2处理自己的业务");

    }

}
