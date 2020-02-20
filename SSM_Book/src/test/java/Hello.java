import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xust.lfh.dao.BookMapper;
import xust.lfh.pojo.Books;
import xust.lfh.service.BookService;
import org.junit.Test;
import java.util.List;

/**
 * Created by LFH on 2020/2/15
 */
public class Hello {
    @Autowired
    BookMapper bookMapper;
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) context.getBean("BookServiceImpl");
        List<Books> books = bookService.queryAllBook();
        System.out.println(books);

        BookMapper book = context.getBean("bookMapper", BookMapper.class);
        System.out.println(book);
    }
    @Test
    public void test2(){
        System.out.println(4-(3.6));
    }

}
