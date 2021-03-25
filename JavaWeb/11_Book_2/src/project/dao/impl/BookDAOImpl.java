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
        String sql = "insert into t_book(name,price,author,sales,stock,img_path) values(?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getPrice(),
                book.getAuthor(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name=?, price=?, author=?, sales=?, stock=?, img_path=? where id = ?";
        return update(sql, book.getName(), book.getPrice(),
                book.getAuthor(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryForBook(Integer id) {
        String sql = "select id, name, price, author, sales, stock, img_path imgPath from t_book where id=?";
        return queryForOne(sql, id);
    }

    @Override
    public List<Book> queryList() {
        String sql = "select id,name,price,author,sales,stock,img_Path from t_book";
        return queryForList(sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        //将Long型转换为int型
        Number count = queryForValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForItems(int begin, int pageSize) {
        String sql = "select id, name, price, author, sales, stock, img_path imgPath " +
                "from t_book limit ?, ?";
        return queryForList(sql, begin, pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = queryForValue(sql, min, max);
        return count.intValue();
    }

    @Override
    public List<Book> queryForItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql  ="select id, name, price, author, sales, stock, img_path imgPath " +
                "from t_book where price between ? and ? order by price limit ?, ?";
        return queryForList(sql, min, max, begin, pageSize);
    }
}
