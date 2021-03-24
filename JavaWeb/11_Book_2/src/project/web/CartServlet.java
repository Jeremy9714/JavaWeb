package project.web;

import project.bean.Book;
import project.bean.Cart;
import project.bean.CartItem;
import project.service.BookService;
import project.service.impl.BookServiceImpl;
import project.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Chenyang
 * @create 2021-03-24-12:35
 */
public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    //添加商品
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取要添加的商品项的id
        int id = WebUtils.parseInt(req.getParameter("bookId"), 0);

        //获取图书信息
        Book book = bookService.queryBookById(id);

        //将图书信息转换为商品项对象
        CartItem cartItem = new CartItem(id, book.getName(), 1, book.getPrice(), book.getPrice());

        //获取Session域中的购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            //如果域中不存在，则创建一个购物车,并储存到Session域中
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        //添加商品项到购物车
        cart.addItem(cartItem);

        System.out.println(cart);

        //重定向回原来商品所在的地址页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    //删除商品
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品编号
        int id = WebUtils.parseInt(req.getParameter("bookId"), 0);

        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            //删除商品项
            cart.deleteItem(id);
            //重定向回原来商品所在的地址页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    //清空商品
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            //清空购物车
            cart.clear();
            //重定向回原来商品所在的地址页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    //更新商品数量
    protected void updateItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品项id
        int id = WebUtils.parseInt(req.getParameter("bookId"), 0);
        //获取商品项修改的数量
        int count = WebUtils.parseInt(req.getParameter("count"), 0);

        //获取购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            //修改商品项数量
            cart.updateCount(id, count);
            //重定向回原来商品所在的地址页面
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }
}
