package project.dao.impl;

import project.bean.Order;
import project.dao.OrderDAO;
import project.utils.JdbcUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @author Chenyang
 * @create 2021-03-24-17:27
 */
public class OrderDAOImpl extends BaseDAO<Order> implements OrderDAO {
    @Override
    public int saveOrder(Order order) {
        Connection connect = JdbcUtils.getConnection();
        String sql = "insert into t_order(order_id,create_Time,price,status,user_Id) values(?,?,?,?,?)";
        return update(connect, sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(),
                order.getUserId());
    }

    @Override
    public List<Order> queryOrders() {
        Connection connect = JdbcUtils.getConnection();
        String sql = "select order_id orderId,create_Time createTime,price,status,user_Id userId from t_order";
        return queryForList(connect, sql);
    }

    @Override
    public int changeOrderStatus(String orderId, Integer status) {
        Connection connect = JdbcUtils.getConnection();
        String sql = "update t_order set status = ? where order_id = ?";
        return update(connect, sql, status, orderId);
    }

    @Override
    public List<Order> queryOrdersByUserId(Integer userId) {
        Connection connect = JdbcUtils.getConnection();
        String sql = "select order_id orderId,create_Time createTime,price,status,user_Id userId from t_order where user_Id = ?";
        return queryForList(connect, sql, userId);
    }
}
