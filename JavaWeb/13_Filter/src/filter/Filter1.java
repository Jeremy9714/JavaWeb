package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Chenyang
 * @create 2021-03-25-10:13
 */
public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("执行filter1的前置代码");
        //所有filter和目标资源默认都由同一条线程执行
        System.out.println("filter1的线程: " + Thread.currentThread().getName());
        //多个filter共同执行时，它们都使用一个request对象
        servletRequest.setAttribute("param", "filterParam");

        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("filter1的线程: " + Thread.currentThread().getName());
        System.out.println("执行filter1的后置代码");
    }

    @Override
    public void destroy() {

    }
}
