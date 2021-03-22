package project.web;

import project.bean.Book;
import project.bean.Page;
import project.service.BookService;
import project.service.impl.BookServiceImpl;
import project.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Chenyang
 * @create 2021-03-21-18:56
 */
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    //分页功能
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数: 当前页码和页面显示数量
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        //2.通过bookService获取Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);

        //3.将Page对象保存到Request域
        req.setAttribute("page", page);

        //4.将请求转发到图书列表管理页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    //显示所有的图书到页面
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过BookService查询全部图书
        List<Book> books = bookService.queryList();

        //2.将全部图书保存到Request域中
        req.setAttribute("books", books);

        //3.将请求转发到book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    //添加图书
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0) + 1;

        //1.将请求参数封装为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());

        //2.通过bookService保存图书
        bookService.addBook(book);

        //3.重定向到图书列表管理页面
        //转发会导致刷新页面时，会重复调用添加图书方法
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, resp);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="
                + pageNo);
    }

    //删除图书
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数: 图书编号
        String id = req.getParameter("id");

        //2.通过bookService删除图书
        bookService.deleteBookById(WebUtils.parseInt(id, 0));

        //3.重定向到图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    //获取指定图书
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数: 图书编号
        String id = req.getParameter("id");

        //查询对应图书并封装到Book类
        Book book = bookService.queryBookById(WebUtils.parseInt(id, 0));

        //将图书保存到Request域中
        req.setAttribute("book", book);

        //请求转发到图书编辑页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    //更新图书
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数，并封装到Book对象中
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());

        //修改图书信息
        bookService.updateBook(book);

        //请求重定向到图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }
}
