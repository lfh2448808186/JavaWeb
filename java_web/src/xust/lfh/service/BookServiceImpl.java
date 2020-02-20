package xust.lfh.service;

import xust.lfh.dao.BookDao;
import xust.lfh.dao.BookDaoImpl;
import xust.lfh.domain.Book;
import xust.lfh.domain.Page;

import java.util.List;

/**
 *图书管理的接口
 */
public class BookServiceImpl implements BookService {


    private BookDao dao = new BookDaoImpl();

    @Override
    public List<Book> findAll() {
        //调用Dao完成
        return dao.findAll();
    }
    // 增加书籍
    @Override
    public void addBook(Book book) {
        dao.addBook(book);
    }
   //通过书名号删除书籍
    @Override
    public void deleteByBookNo(Book book) {
        dao.deleteBook(book);
    }
    //通过作者查询书籍，返回
    @Override
    public List<Book> queryByAuthor(Book book) {
        return dao.queryByAuthor(book);
    }

    @Override
    public List<Book> queryBookName(Book book) {
        return dao.queryBookName(book);
    }

    @Override
    public Book queryByNo(Book book) {
        return dao.queryByNo(book);
    }

    @Override
    public void updateBook(Book book) {
        dao.updateBook(book);
    }

    @Override
    public Page<Book> queryBookByPage(String _currentPage,String  _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        //1.创建一个空的Page对象
        Page<Book> pb = new Page<Book>();
        //2.设置参数
        pb.setCurrentpage(currentPage);
        pb.setRows(rows);
        //3.调用dao 查询总记录数
        int totalCount = dao.queryTotalCount();
        pb.setTotalCount(totalCount);

        //4.调用dao查询List集合 ，queryPage(int start,int
        int start = (currentPage -1) * rows;
        List<Book> list = dao.queryBookByPage(start,rows);
        pb.setList(list);


        //5.计算总页码
        int totalPage = (totalCount % rows) == 0 ? (totalCount/rows) : (totalCount/rows)+1;
        pb.setTotalPage(totalPage);
        return pb;
    }
}
