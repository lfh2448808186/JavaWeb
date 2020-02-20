package xust.lfh.servlet;

import org.apache.commons.beanutils.BeanUtils;
import xust.lfh.domain.Book;
import xust.lfh.service.BookService;
import xust.lfh.service.BookServiceImpl;
import xust.lfh.util.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/queryBookNameServlet")
public class QueryBookNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String bookName = request.getParameter("bookName");
        Book book = new Book();
        book.setBookName(bookName);
        BookService service = new BookServiceImpl();
        List<Book> books = service.queryBookName(book);
        request.setAttribute("books",books);
        request.getRequestDispatcher(request.getContextPath()+"/webroot/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
