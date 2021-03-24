package project.service.impl;

import project.bean.*;
import project.dao.BookDAO;
import project.dao.OrderItemDAO;
import project.dao.impl.BookDAOImpl;
import project.dao.impl.OrderDAOImpl;
import project.dao.impl.OrderItemDAOImpl;
import project.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Chenyang
 * @create 2021-03-24-18:25
 */
public class OrderServiceImpl implements OrderService {
    private OrderDAOImpl orderDAO = new OrderDAOImpl();
    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        //订单号
        String orderId = System.currentTimeMillis() + "" + userId;
        //创建一个订单对象
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        //将订单保存到数据库
        orderDAO.saveOrder(order);

        //将所有商品转换为订单项保存到数据库
        Map<Integer, CartItem> items = cart.getItems();
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            //将每一个商品项转换为订单项
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(),
                    cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            //保存订单项
            orderItemDAO.saveOrderItem(orderItem);

            //更新库存和销量
            Book book = bookDAO.queryForBook(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(Math.max(0, book.getStock() - cartItem.getCount()));
            bookDAO.updateBook(book);
        }

        //生成订单后清空购物车
        cart.clear();

        return orderId;
    }

    @Override
    public List<Order> showAllOrders() {
        return orderDAO.queryOrders();
    }

    @Override
    public void dispatchOrder(String orderId) {
        int count = orderDAO.changeOrderStatus(orderId, 1);
        if (count != 0) {
            System.out.println("发货成功");
        } else {
            System.out.println("发货失败");
        }
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) {
        return orderItemDAO.queryOrderItemsByOrderId(orderId);
    }

    @Override
    public List<Order> showMyOrders(Integer userId) {
        return orderDAO.queryOrdersByUserId(userId);
    }

    @Override
    public void signOrder(String orderId) {
        int count = orderDAO.changeOrderStatus(orderId, 2);
        if (count != 0) {
            System.out.println("签收成功");
        } else {
            System.out.println("签收失败");
        }
    }
}
