package project.service;

import project.bean.Cart;
import project.bean.Order;
import project.bean.OrderItem;

import java.util.List;

/**
 * @author Chenyang
 * @create 2021-03-24-18:17
 */
public interface OrderService {

    //生成订单
    public String createOrder(Cart cart, Integer userId);

    //显示全部订单
    public List<Order> showAllOrders();

    //订单发货
    public void dispatchOrder(String orderId);

    //查看订单详情
    public List<OrderItem> showOrderDetail(String orderId);

    //查看自己的订单
    public List<Order> showMyOrders(Integer userId);

    //签收订单
    public void signOrder(String orderId);
}
