package servlet;

import util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Chenyang
 * @create 2021-03-23-11:00
 */
public class CookieServlet extends BaseServlet {

    //Cookie的默认生命周期
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("key4", "value4");

        //设置存活时间
        //默认为负数，表示关闭浏览器时删除Cookie
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);
        resp.getWriter().write("默认生命周期key4的Cookie已创建");
    }

    //立刻删除Cookie
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //找到要删除的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key4", req.getCookies());

        if (cookie != null) {
            //设置存活时间
            //参数为0表示立刻删除Cookie
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
            resp.getWriter().write("key4的Cookie已经被删除");
        }
    }

    //设定Cookie的生命周期
    protected void setLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //找到要删除的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key4", req.getCookies());

        if (cookie!=null) {
            //设置存活时间
            //参数为正表示Cookie的最大生存时间
            cookie.setMaxAge(3600);
            resp.addCookie(cookie);
            resp.getWriter().write("已更改key4的Cookie的生存时间至3600秒");
        }
    }

    //修改Cookie的值
    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //方法一: 创建一个同名的Cookie对象赋予新值，再通知客户端保存
//        Cookie cookie = new Cookie("key1","newValue1");
//        resp.addCookie(cookie);
//        resp.getWriter().write("Cookie的值已修改");

        //方法二: 找到要修改的Cookie对象，调用setValue()方法进行修改
        Cookie cookie = CookieUtils.findCookie("key2", req.getCookies());
        if (cookie != null) {
            cookie.setValue("newValue2");
            resp.addCookie(cookie);
            resp.getWriter().write("Cookie的值已修改");
        }
    }

    //获取Cookie
    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Cookie数组
        Cookie[] cookies = req.getCookies();

        //输出所有的Cookie对象
        for (Cookie cookie : cookies) {
            resp.getWriter().write("Cookie: [" + cookie.getName() + "=" + cookie.getValue() + "]<br>");
        }

        //查找指定的key的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key1", cookies);
        if (cookie != null) {
            resp.getWriter().write("找到了需要的Cookie");
        }

    }

    //创建Cookie
    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建Cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        //通知客户端保存Cookie
        resp.addCookie(cookie);

        //创建Cookie对象
        Cookie cookie1 = new Cookie("key2", "value2");
        //通知客户端保存Cookie
        resp.addCookie(cookie1);

        //创建Cookie对象
        Cookie cookie2 = new Cookie("key3", "value3");
        //通知客户端保存Cookie
        resp.addCookie(cookie2);

        resp.getWriter().write("Cookie创建成功");

    }
}
