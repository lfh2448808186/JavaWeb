package xust.lfh.servlet;

import xust.lfh.domain.Book;
import xust.lfh.service.BookService;
import xust.lfh.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/bookListServlet")
public class BookListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("html/text;charset=utf-8");
        BookService service = new BookServiceImpl();
        List<Book> books = service.findAll();
        //2.将list存入request对象
        request.setAttribute("books",books);
        request.getRequestDispatcher(request.getContextPath()+"/webroot/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
