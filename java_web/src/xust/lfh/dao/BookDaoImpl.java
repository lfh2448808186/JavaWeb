package xust.lfh.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import xust.lfh.domain.Book;
import xust.lfh.util.JDBCUtils;

import java.util.List;

public class BookDaoImpl implements BookDao{

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /*
    使用JDBC操作数据库
     */

    /**
     * 查询所有图书信息
     * @return
     */
    @Override
    public List<Book> findAll() {
        String sql = "select * from book";
        List<Book> book = template.query(sql, new BeanPropertyRowMapper<>(Book.class));
        return book;
    }
    
    @Override
    public void addBook(Book book) {
        String sql = "insert into book ( bookNo,bookName,author, publish,publishTime, price)  values(?,?,?,?,?,?)";
        template.update(sql,book.getBookNo(),book.getBookName(),book.getAuthor(),book.getPublish(),book.getPublishTime(),book.getPrice());
    }

    @Override
    public void deleteBook(Book book) {
        String sql = "delete from book where bookNo = ?";
        template.update(sql,book.getBookNo());
    }

    @Override
    public List<Book> queryByAuthor(Book book) {
        String sql = "select * from book where author = ?";
        List<Book> books = template.query(sql, new BeanPropertyRowMapper<>(Book.class), book.getAuthor());
        return books;
    }

    @Override
    public List<Book> queryBookName(Book book) {
        String sql = "select * from book where  bookName = ? ";

        List<Book> books = template.query(sql, new BeanPropertyRowMapper<>(Book.class), book.getBookName());
        return books;
    }

    @Override
    public Book queryByNo(Book book) {
        String sql = "select * from book where no = ?";
        Book books = template.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), book.getNo());
        return books;

    }

    @Override
    public void updateBook(Book book) {
        String sql = " update book set bookNo=?,bookName = ? ,author = ?,publish = ?, publishTime =?,price = ? where no = ?";
        template.update(sql,book.getBookNo(),book.getBookName(), book.getAuthor(),book.getPublish(),
                book.getPublishTime(),book.getPrice(),book.getNo());
    }

    @Override
    public int queryTotalCount() {
        String sql = "select count(*) from book";
        return template.queryForObject(sql,Integer.class);
    }

    @Override
    public List<Book> queryBookByPage(int start, int rows) {
        String sql = "select * from book limit ? , ?";

        return template.query(sql,new BeanPropertyRowMapper<>(Book.class),start,rows);
    }


}
