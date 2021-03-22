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

/**
 * @author Chenyang
 * @create 2021-03-22-20:10
 */
public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    //处理价格区间的分页
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数: 当前页码、页面显示数量、价格最大值和价格最小值
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);

        //2.通过bookService获取Page对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);

        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");

        //若含有最小价格的参数，追加到分页条的地址参数中
        if(req.getParameter("min")!=null){
            sb.append("&min=").append(req.getParameter("min"));
        }
        //若含有最高价格的参数，追加到分页条的地址参数中
        if(req.getParameter("max")!=null){
            sb.append("&max=").append(req.getParameter("max"));
        }

        //设置后台的分页条请求地址
        page.setUrl(sb.toString());

        //3.将Page对象保存到Request域
        req.setAttribute("page", page);

        //4.将请求转发到图书列表管理页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);

    }

    //分页功能
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.获取请求参数: 当前页码和页面显示数量
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        //2.通过bookService获取Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);

        //设置后台的分页条请求地址
        page.setUrl("client/bookServlet?action=page");

        //3.将Page对象保存到Request域
        req.setAttribute("page", page);

        //4.将请求转发到图书列表管理页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
