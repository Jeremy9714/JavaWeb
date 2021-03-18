package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 监听器的使用
 * @author Chenyang
 * @create 2021-03-18-22:48
 */
public class MyListener implements ServletContextListener {

    //在ServletContext对象创建之后调用，做初始化
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被创建了");
    }

    //在ServletContext对象销毁之后调用
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被销毁了");
    }
}
