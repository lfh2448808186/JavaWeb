import lfh.pojo.Books;
import lfh.service.BookService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by LFH on 2020/2/15
 */
public class Book {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) context.getBean("BookServiceImpl");
        List<Books> books = bookService.queryAllBook();
        System.out.println(books);

    }
}
