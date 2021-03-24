package project.test;

import org.junit.Test;
import project.bean.OrderItem;
import project.dao.impl.OrderItemDAOImpl;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Chenyang
 * @create 2021-03-24-17:54
 */
public class OrderItemDAOImplTest {
    private OrderItemDAOImpl orderItemDAO = new OrderItemDAOImpl();

    @Test
    public void saveOrderItem() {
        int count = orderItemDAO.saveOrderItem(new OrderItem(null, "java从入门到精通", 2, new BigDecimal(100),
                new BigDecimal(200), "1234567890"));
        if (count != 0) {
            System.out.println("保存成功");
        } else {
            System.out.println("保存失败");
        }
    }

    @Test
    public void queryOrderItemsByOrderId() {
        List<OrderItem> orderItems = orderItemDAO.queryOrderItemsByOrderId("1234567890");
        orderItems.forEach(System.out::println);
    }
}