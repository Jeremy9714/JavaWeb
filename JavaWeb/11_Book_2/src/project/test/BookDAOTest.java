package project.test;

import org.junit.Test;
import project.bean.Book;
import project.dao.BookDAO;
import project.dao.impl.BookDAOImpl;
import project.utils.JdbcUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Chenyang
 * @create 2021-03-21-18:16
 */
public class BookDAOTest {
    private BookDAO bookDAO = new BookDAOImpl();

    @Test
    public void addBook() {
        int count = bookDAO.addBook(new Book(null, "新书_1", new BigDecimal(9999),
                "作者_1", 100, 200, null));
        if (count != 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    @Test
    public void deleteBookById() {
        int count = bookDAO.deleteBookById(21);
        if (count != 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void updateBook() {
        int count = bookDAO.updateBook(new Book(21, "新书_2", new BigDecimal(999),
                "作者_2", 300, 0, null));
        if (count != 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    @Test
    public void queryForBook() {
        Book book = bookDAO.queryForBook(21);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("查询失败");
        }
    }

    @Test
    public void queryList() {
        List<Book> books = bookDAO.queryList();
        if (books.size() != 0) {
            books.forEach(System.out::println);
        } else {
            System.out.println("查询失败");
        }
    }

    @Test
    public void queryForPageTotalCount() {
        int count = bookDAO.queryForPageTotalCount();
        System.out.println("图书总数: " + count);
    }

    @Test
    public void queryForItems() {
        List<Book> books = bookDAO.queryForItems(8, 4);
        books.forEach(System.out::println);
    }
}