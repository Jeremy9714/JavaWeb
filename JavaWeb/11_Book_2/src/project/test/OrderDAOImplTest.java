package project.test;

import org.junit.Test;
import project.bean.Order;
import project.dao.OrderDAO;
import project.dao.impl.OrderDAOImpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Chenyang
 * @create 2021-03-24-17:53
 */
public class OrderDAOImplTest {
    private OrderDAO orderDAO = new OrderDAOImpl();

    @Test
    public void saveOrder() {
        int count = orderDAO.saveOrder(new Order("1234567890", new Date(), new BigDecimal(100), 0, 111));
        if (count != 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    @Test
    public void queryOrders() {
        List<Order> orders = orderDAO.queryOrders();
        orders.forEach(System.out::println);
    }

    @Test
    public void changeOrderStatus() {
        int count = orderDAO.changeOrderStatus("1234567890", 1);
        if (count != 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    @Test
    public void queryOrdersByUserId() {
        List<Order> orders = orderDAO.queryOrdersByUserId(1);
        orders.forEach(System.out::println);
    }
}