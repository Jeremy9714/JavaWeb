package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author Chenyang
 * @create 2021-03-21-14:10
 */
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决post请求的中文乱码问题
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("Access-Control-Allow-Origin","*");
        //获取业务鉴别字符串
        String actionName = req.getParameter("action");

        try {
            //通过字符串胡获取相应的方法反射对象
            Method method = this.getClass().getDeclaredMethod(actionName, HttpServletRequest.class, HttpServletResponse.class);
            //调用方法
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            //将异常向上抛给Filter过滤器
            throw new RuntimeException(e);
        }
    }
}
