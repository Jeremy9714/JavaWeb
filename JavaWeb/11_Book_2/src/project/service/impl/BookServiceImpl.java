package project.service.impl;

import project.bean.Book;
import project.bean.Page;
import project.dao.BookDAO;
import project.dao.impl.BookDAOImpl;
import project.service.BookService;

import java.util.List;

/**
 * @author Chenyang
 * @create 2021-03-21-18:36
 */
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    public void addBook(Book book) {
        int count = bookDAO.addBook(book);
        if (count != 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    @Override
    public void deleteBookById(Integer id) {
        int count = bookDAO.deleteBookById(id);
        if (count != 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @Override
    public void updateBook(Book book) {
        int count = bookDAO.updateBook(book);
        if (count != 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDAO.queryForBook(id);
    }

    @Override
    public List<Book> queryList() {
        return bookDAO.queryList();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        //获取数据的总数
        int pageTotalCount = bookDAO.queryForPageTotalCount();
        //获取总页数
        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize != 0) {
            pageTotal++;
        }

        //设置属性
        page.setPageSize(pageSize);
        page.setPageTotalCount(pageTotalCount);
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);

        //获取当前页的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        //获取当前页的数据
        List<Book> items = bookDAO.queryForItems(begin, pageSize);
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();
        //获取价格区间的总数
        int pageTotalCount = bookDAO.queryForPageTotalCountByPrice(min, max);
        //获取总页数
        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize != 0) {
            pageTotal++;
        }
        //设置属性
        page.setPageSize(pageSize);
        page.setPageTotalCount(pageTotalCount);
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);

        //获取当前页的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;

        //获取当前页的数据
        List<Book> items = bookDAO.queryForItemsByPrice(begin, pageSize, min, max);
        page.setItems(items);

        return page;
    }
}
