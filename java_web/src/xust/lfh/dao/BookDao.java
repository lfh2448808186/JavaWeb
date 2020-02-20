package xust.lfh.dao;

import xust.lfh.domain.Book;

import java.util.List;

/**
 * 图书操作的Dao
 */
public interface BookDao {
    List<Book> findAll(); //查询出所有图书

    void addBook(Book book); //增加新的图书；

    void deleteBook(Book book); //删除图书

    List<Book> queryByAuthor(Book book); //通过作者名进行查询

    List<Book> queryBookName(Book book); //通过图书名查询

    Book queryByNo(Book book);  //通过书号进行查询

    void updateBook(Book book); //修改图书信息


    /**
     * 查询总记录数
     * @return 查询总记录数
     */
    int queryTotalCount();

    /**
     * 分页查询每一记录
     * @param start
     * @param rows
     * @return  查询总页数
     */
    List<Book> queryBookByPage(int start, int rows);

}
