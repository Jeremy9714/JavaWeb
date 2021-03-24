package project.dao;

import project.bean.Order;

import java.util.List;

/**
 * @author Chenyang
 * @create 2021-03-24-17:15
 */
public interface OrderDAO {

    //保存订单
    public int saveOrder(Order order);

    //查询全部订单
    public List<Order> queryOrders();

    //修改订单状态
    public int changeOrderStatus(String orderId, Integer status);

    //根据用户编号查询订单信息
    public List<Order> queryOrdersByUserId(Integer userId);


}
