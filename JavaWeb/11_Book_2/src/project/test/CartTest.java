package project.test;

import org.junit.Test;
import project.bean.Cart;
import project.bean.CartItem;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Chenyang
 * @create 2021-03-24-12:06
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "item_1", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "item_2", 2, new BigDecimal(200), new BigDecimal(400)));
        cart.addItem(new CartItem(1, "item_1", 1, new BigDecimal(100), new BigDecimal(100)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "item_1", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "item_2", 2, new BigDecimal(200), new BigDecimal(400)));
        cart.addItem(new CartItem(1, "item_1", 1, new BigDecimal(100), new BigDecimal(100)));

        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "item_1", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "item_2", 2, new BigDecimal(200), new BigDecimal(400)));
        cart.addItem(new CartItem(1, "item_1", 1, new BigDecimal(100), new BigDecimal(100)));

        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "item_1", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "item_2", 2, new BigDecimal(200), new BigDecimal(400)));
        cart.addItem(new CartItem(1, "item_1", 1, new BigDecimal(100), new BigDecimal(100)));

        cart.updateCount(2, 7);
        System.out.println(cart);
    }
}