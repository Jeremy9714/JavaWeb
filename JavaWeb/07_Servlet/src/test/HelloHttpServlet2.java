package test; /**
 * @author Chenyang
 * @create 2021-03-09-16:15
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class HelloHttpServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloHttpServlet2的doGet方法");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloHttpServlet2的doPost方法");
    }
}
