package project.dao;

import project.bean.OrderItem;

import java.util.List;

/**
 * @author Chenyang
 * @create 2021-03-24-17:42
 */
public interface OrderItemDAO {

    //保存订单项
    public int saveOrderItem(OrderItem orderItem);

    //根据订单号查询订单明细
    public List<OrderItem> queryOrderItemsByOrderId(String orderId);
}
