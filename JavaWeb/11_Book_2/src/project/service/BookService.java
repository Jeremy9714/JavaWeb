package project.service;

import project.bean.Book;
import project.bean.Page;

import java.util.List;

/**
 * @author Chenyang
 * @create 2021-03-21-18:33
 */
public interface BookService {

    //添加新书
    void addBook(Book book);

    //删除书籍
    void deleteBookById(Integer id);

    //修改书籍
    void updateBook(Book book);

    //查询书籍
    Book queryBookById(Integer id);

    //查询所有书籍
    List<Book> queryList();

    //获取分页
    Page<Book> page(int pageNo, int pageSize);

    //获取价格区间的分页
    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
