package xust.lfh.service;

import xust.lfh.domain.Book;
import xust.lfh.domain.Page;

import java.util.List;

public interface BookService {
    List<Book> findAll(); //查询所有图书

    void addBook(Book book); //增加书籍

     void deleteByBookNo(Book book); //删除图书w

    List<Book> queryByAuthor(Book book);  // 通过作者名返回图书

    List<Book> queryBookName(Book book);  //通过书名查询图书

    Book queryByNo(Book book); //通过图书号查询图书

    void updateBook(Book book); //修改图书信息
    //查询出图书的页数，和总条数
    Page<Book> queryBookByPage(String  currentPage, String  rows);
}
