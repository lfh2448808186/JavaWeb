package xust.lfh.service;

import xust.lfh.dao.BookMapper;
import xust.lfh.pojo.Books;

import java.util.List;

/**
 * Created by LFH on 2020/2/15
 */
public class BookServiceImpl implements BookService {


    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books book) {
        return bookMapper.addBook(book);
    }

    public int deleteBookByNo(int bookNo) {
        return bookMapper.deleteBookByNo(bookNo);
    }

    public int updateBook(Books book) {
        return bookMapper.updateBook(book);
    }

    public Books queryBookByNo(int bookNo) {
        return bookMapper.queryBookByNo(bookNo);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }
}
