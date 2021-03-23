package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Chenyang
 * @create 2021-03-23-17:14
 */
public class SessionServlet extends BaseServlet {

    //获取Session的默认超时时长
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("Session的默认超时时长为: " + maxInactiveInterval);
    }

    //设置单独的Session的超时时长
    protected void setLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session会话
        HttpSession session = req.getSession();

        //设置单独的Session的超时时长，单位为秒
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("已将此Session的超时时长设置为3秒钟");
    }

    //销毁当前Session会话
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取当前Session会话
        HttpSession session = req.getSession();

        //让当前Session立刻超时
        session.invalidate();
        resp.getWriter().write("当前Session会话已被设置为超时");
    }

    //往Session域中保存数据
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "value1");
        resp.getWriter().write("已向Session域保存了数据");
    }

    //从Session域中获取数据
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object value = req.getSession().getAttribute("key1");
        resp.getWriter().write("从Session域中获取的key1的值为: " + value);
    }

    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session会话
        HttpSession session = req.getSession();

        //返回会话id到客户端
        resp.getWriter().write("Session会话的id为: " + session.getId() + "<br>");

        //判断此会话是否是第一次创建
        boolean isNew = session.isNew();
        if (isNew) {
            resp.getWriter().write("Session是否为第一次创建: " + isNew);
        } else {
            resp.getWriter().write("Session是否为第一次创建: " + isNew);
        }
    }
}
