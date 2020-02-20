package xust.lfh.servlet;

import xust.lfh.domain.Book;
import xust.lfh.domain.User;
import xust.lfh.service.BookService;
import xust.lfh.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/queryByNoServlet")
public class QueryByNoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("html/txt;utf-8");
        String no = request.getParameter("no");
        Book book = new Book();
        book.setNo(Integer.parseInt(no));
        BookService service = new BookServiceImpl();
        Book books = service.queryByNo(book);
        request.setAttribute("books",books);
        request.getRequestDispatcher(request.getContextPath()+"/webroot/updateBook.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
