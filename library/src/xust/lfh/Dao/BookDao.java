package xust.lfh.Dao;

import xust.lfh.Bean.Book;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao extends Until  {


     //查询所有图书信息
    public List<Book> selectAll() {
        List<Book> list = new ArrayList<>();
        try {
            conn = myConnection();
            String sql = "select * from book ";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Book book = new Book();
                String bookNo = rs.getString("bookNo");
                String bookName = rs.getString ("bookName");
                String author = rs.getString("author");
                String publish = rs.getString("publish");
                String publishTime = rs.getString("publishTime");
                String price = rs.getString("price");
                book.setBookNo(bookNo);
                book.setBookName(bookName);
                book.setAuthor(author);
                book.setPublish(publish);
                book.setPublishTime(publishTime);
                book.setPrice(price);
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //按书名查询
    public List<Book> selectBookName(String bookNameIn) {
        List<Book> list = new ArrayList<>();
        try {
            conn = myConnection();
            String sql = "select * from book where  bookName = ? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,bookNameIn);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Book book = new Book();
                String bookNo = rs.getString("bookNo");
                String bookName = rs.getString ("bookName");
                String author = rs.getString("author");
                String publish = rs.getString("publish");
                String publishTime = rs.getString("publishTime");
                String price = rs.getString("price");
                book.setBookNo(bookNo);
                book.setBookName(bookName);
                book.setAuthor(author);
                book.setPublish(publish);
                book.setPublishTime(publishTime);
                book.setPrice(price);
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //按作者查询
    public List<Book> selectAuthor(String authorName) {
        List<Book> list = new ArrayList<>();
        try {
            conn = myConnection();
            String sql = "select * from book where  author  = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,authorName);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Book book = new Book();
                String bookNo = rs.getString("bookNo");
                String bookName = rs.getString ("bookName");
                String author = rs.getString("author");
                String publish = rs.getString("publish");
                String publishTime = rs.getString("publishTime");
                String price = rs.getString("price");
                book.setBookNo(bookNo);
                book.setBookName(bookName);
                book.setAuthor(author);
                book.setPublish(publish);
                book.setPublishTime(publishTime);
                book.setPrice(price);
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //增加书籍
    public boolean add(Book book) {
        conn = myConnection();
        String sql = "insert into book ( bookNo,bookName,author, publish,publishTime, price)  values(?,?,?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,book.getBookNo());
            pstmt.setString(2,book.getBookName());
            pstmt.setString(3,book.getAuthor());
            pstmt.setString(4,book.getPublish());
            pstmt.setString(5,book.getPublishTime());
            pstmt.setString(6,book.getPrice());

            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }


    //删除书籍
    public boolean delete(String bookNameIn) {
        conn = myConnection();
        try{
            String sql = "delete from book where bookName = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,bookNameIn);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
