package project.dao.impl;

import project.bean.Book;
import project.dao.BookDAO;
import project.utils.JdbcUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @author Chenyang
 * @create 2021-03-21-17:57
 */
public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {
    @Override
    public int addBook(Book book) {
        Connection connect = JdbcUtils.getConnection();
        String sql = "insert into t_book(name,price,author,sales,stock,img_path) values(?,?,?,?,?,?)";
        return update(connect, sql, book.getName(), book.getPrice(),
                book.getAuthor(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        Connection connect = JdbcUtils.getConnection();
        String sql = "delete from t_book where id = ?";
        return update(connect, sql, id);
    }

    @Override
    public int updateBook(Book book) {
        Connection connect = JdbcUtils.getConnection();
        String sql = "update t_book set name=?, price=?, author=?, sales=?, stock=?, img_path=? where id = ?";
        return update(connect, sql, book.getName(), book.getPrice(),
                book.getAuthor(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryForBook(Integer id) {
        Connection connect = JdbcUtils.getConnection();
        String sql = "select id, name, price, author, sales, stock, img_path imgPath from t_book where id=?";
        return queryForOne(connect, sql, id);
    }

    @Override
    public List<Book> queryList() {
        Connection connect = JdbcUtils.getConnection();
        String sql = "select id,name,price,author,sales,stock,img_Path from t_book";
        return queryForList(connect, sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        Connection connect = JdbcUtils.getConnection();
        String sql = "select count(*) from t_book";
        //将Long型转换为int型
        Number count = queryForValue(connect, sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForItems(int begin, int pageSize) {
        Connection connect = JdbcUtils.getConnection();
        String sql = "select id, name, price, author, sales, stock, img_path imgPath " +
                "from t_book limit ?, ?";
        return queryForList(connect, sql, begin, pageSize);
    }
}
