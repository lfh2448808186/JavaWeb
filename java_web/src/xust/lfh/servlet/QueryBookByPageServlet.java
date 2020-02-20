package xust.lfh.servlet;

import xust.lfh.domain.Book;
import xust.lfh.domain.Page;
import xust.lfh.service.BookService;
import xust.lfh.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/queryBookByPageServlet")
public class QueryBookByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        String currentpage =
                request.getParameter("currentpage");
        String rows =
                request.getParameter("rows");
        if ( currentpage == null || "".equals(currentpage)) {
            currentpage = "1";
        }
        if (rows == null || "".equals(rows)){
            rows = "5";
        }
        //2.调用service查询
        BookService service = new BookServiceImpl();
        Page<Book> pb = service.queryBookByPage(currentpage,rows);

        //3.将Page存入request
        request.setAttribute("pb",pb);
        //4.转发到list.jsp
        request.getRequestDispatcher(request.getContextPath()+"/webroot/list2.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
