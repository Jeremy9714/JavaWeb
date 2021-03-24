package project.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Cart类是购物车对象
 *
 * @author Chenyang
 * @create 2021-03-24-11:24
 */
public class Cart {
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    //添加商品项
    public void addItem(CartItem cartItem) {
        //先查看购物车中是已经添加过该商品项
        CartItem item = items.get(cartItem.getId());

        if (item == null) {
            //没添加过此商品
            items.put(cartItem.getId(), cartItem);
        } else {
            //添加过此商品
            //重新计算该商品的数量及总价格
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
            items.put(item.getId(), item);
        }
    }

    //删除商品项
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    //清空购物车
    public void clear() {
        items.clear();
    }

    //修改商品数量
    public void updateCount(Integer id, Integer count) {
        CartItem item = items.get(id);
        if (item != null) {
            //更新商品数量及总价格
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(count)));
        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;

        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
