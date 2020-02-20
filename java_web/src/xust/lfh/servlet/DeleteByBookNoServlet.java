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

@WebServlet(urlPatterns = "/deleteByBookNoServlet")
public class DeleteByBookNoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String bookNo = request.getParameter("bookNo");
        Book book = new Book();
        book.setBookNo(Integer.parseInt(bookNo));
        BookService service = new BookServiceImpl();
        service.deleteByBookNo(book);
        request.getRequestDispatcher(request.getContextPath()+"bookListServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
