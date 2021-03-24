package project.web;

import project.bean.Cart;
import project.bean.User;
import project.service.OrderService;
import project.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Chenyang
 * @create 2021-03-24-18:59
 */
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    //生成订单
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车对象和用户编号
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User loginUser = (User) req.getSession().getAttribute("user");

        //若用户未登录，则跳转到用户登录页面
        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        Integer userId = loginUser.getId();

        //生成订单
        String orderId = orderService.createOrder(cart, userId);

        System.out.println(orderId);

        //保存订单号
        req.getSession().setAttribute("orderId", orderId);

        //重定向到结算完成页面
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }

    //查询所有订单
    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    //订单发货
    protected void dispatchOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    //查看订单详情
    protected void showOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    //查看自己的订单
    protected void showMyOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    //订单收货
    protected void signOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
