package project.dao;

import project.bean.Book;

import java.util.List;

/**
 * @author Chenyang
 * @create 2021-03-21-17:51
 */
public interface BookDAO {

    //添加一本书
    int addBook(Book book);

    //删除一本书
    int deleteBookById(Integer id);

    //修改书的信息
    int updateBook(Book book);

    //查询一本书
    Book queryForBook(Integer id);

    //查询所有书
    List<Book> queryList();

    //查询图书总数
    Integer queryForPageTotalCount();

    //查询指定页的图书
    List<Book> queryForItems(int begin, int pageSize);
}
