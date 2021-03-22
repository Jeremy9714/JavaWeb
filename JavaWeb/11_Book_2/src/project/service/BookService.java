package project.service;

import project.bean.Book;

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
}
