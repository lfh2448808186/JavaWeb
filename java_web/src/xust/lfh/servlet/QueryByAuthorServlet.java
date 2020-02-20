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

@WebServlet(urlPatterns = "/queryByAuthorServlet")
public class QueryByAuthorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("utf-8");
        String author = request.getParameter("author");
        Book book = new Book();
        book.setAuthor(author);

        BookService service = new BookServiceImpl();
        List<Book> books = service.queryByAuthor(book);
        request.setAttribute("books",books);
        request.getRequestDispatcher(request.getContextPath()+"/webroot/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
