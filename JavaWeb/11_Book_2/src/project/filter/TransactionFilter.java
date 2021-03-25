package project.filter;

import project.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * 对业务层方法的过滤器
 *
 * @author Chenyang
 * @create 2021-03-25-15:23
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            filterChain.doFilter(servletRequest, servletResponse);
            JdbcUtils.commitAndClose();//提交事务
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtils.rollbackAndClose();//回滚事务
            throw new RuntimeException(e);//把异常在抛给tomcat服务器管理，展示友好的错误界面
        }
    }

    @Override
    public void destroy() {

    }
}
