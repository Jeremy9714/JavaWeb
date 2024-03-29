package project.test;

import org.junit.Test;
import project.bean.Book;
import project.bean.Page;
import project.service.BookService;
import project.service.impl.BookServiceImpl;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Chenyang
 * @create 2021-03-21-18:40
 */
public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "新书", new BigDecimal(1000),
                "作者", 1000, 10, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22, "新书2", new BigDecimal(10000),
                "作者", 1000, 0, null));
    }

    @Test
    public void queryForBook() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryList() {
        System.out.println(bookService.queryList());
    }

    @Test
    public void page() {
        Page<Book> page = bookService.page(3, 4);
        System.out.println(page);
    }

    @Test
    public void pageByPrice() {
        Page<Book> page = bookService.pageByPrice(1, 4, 20, 100);
        System.out.println(page);
    }
}