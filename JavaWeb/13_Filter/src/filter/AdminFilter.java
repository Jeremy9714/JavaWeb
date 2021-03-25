package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Chenyang
 * @create 2021-03-24-21:07
 */
public class AdminFilter implements Filter {

    public AdminFilter() {
        System.out.println("1.Filter的构造器方法");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2.Filter的ini初始化t方法");

        //获取Filter过滤器的别名
        System.out.println("过滤器名称: " + filterConfig.getFilterName());
        //获取web.xml配置文件中的初始化参数
        System.out.println("uername: " + filterConfig.getInitParameter("username"));
        System.out.println("url: " + filterConfig.getInitParameter("url"));
        //获取ServletContext对象
        System.out.println("ServletContext对象: " + filterConfig.getServletContext());
    }

    //专门用于拦截请求，可以做权限检查
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3.Filter的doFilter()过滤方法");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        //user等于null，说明还没有登录
        if (user == null) {
            request.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            return;
        } else {
            //让程序继续往下访问用户的目标资源
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("4.Filter的destroy销毁方法");
    }
}
