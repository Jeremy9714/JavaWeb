package project.dao.impl;

import project.bean.OrderItem;
import project.dao.OrderItemDAO;
import project.utils.JdbcUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @author Chenyang
 * @create 2021-03-24-17:44
 */
public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements OrderItemDAO {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        Connection connect = JdbcUtils.getConnection();
        String sql = "insert into t_order_item(name, count, price, total_Price, order_Id) values(?,?,?,?,?)";
        return update(connect, sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(),
                orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {
        Connection connect = JdbcUtils.getConnection();
        String sql = "select id, name, count, price, total_Price totalPrice, order_id orderId " +
                "from t_order_item where order_Id = ?";
        return queryForList(connect, sql, orderId);
    }
}
