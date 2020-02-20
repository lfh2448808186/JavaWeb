package xust.lfh.dao;

import xust.lfh.pojo.Books;

import java.util.List;

/**
 * Created by LFH on 2020/2/15
 */
public interface BookMapper {

    //增加一本书
    int addBook(Books book);

    //删除一本书
    int deleteBookByNo(int bookNo);

    //修改一本书
    int updateBook(Books book);

    //根据书号查询
    Books queryBookByNo(int bookNo);

    //查询全部书
    List<Books> queryAllBook();
}
