package project.test;

import org.junit.Test;
import project.bean.Cart;
import project.bean.CartItem;
import project.bean.Order;
import project.bean.OrderItem;
import project.service.OrderService;
import project.service.impl.OrderServiceImpl;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Chenyang
 * @create 2021-03-24-18:42
 */
public class OrderItemServiceImplTest {
    private OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "item_1", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "item_2", 2, new BigDecimal(200), new BigDecimal(400)));
        cart.addItem(new CartItem(1, "item_1", 1, new BigDecimal(100), new BigDecimal(100)));

        String orderId = orderService.createOrder(cart, 1);
        System.out.println("订单号为: " + orderId);

    }

    @Test
    public void showAllOrders() {
        List<Order> orders = orderService.showAllOrders();
        orders.forEach(System.out::println);
    }

    @Test
    public void dispatchOrder() {
        orderService.dispatchOrder("16166117020861");
    }

    @Test
    public void showOrderDetail() {
        List<OrderItem> orderItems = orderService.showOrderDetail("16166117020861");
        orderItems.forEach(System.out::println);
    }

    @Test
    public void showMyOrders() {
        List<Order> orders = orderService.showMyOrders(1);
        orders.forEach(System.out::println);
    }

    @Test
    public void signOrder() {
        orderService.signOrder("16166117020861");
    }
}