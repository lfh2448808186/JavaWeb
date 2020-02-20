package xust.lfh.servlet;


import xust.lfh.Bean.Book;
import xust.lfh.Bean.User;
import xust.lfh.Dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/Book")
public class BookServlet extends HttpServlet {
    static BookDao bookDao = new BookDao();
    private String uri;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 获取操作的类型
        String type = request.getParameter("type");

        // 判断
        if ("add".equals(type)) {
            // 添加新书
            add(request, response);
        }

        else if ("selectAllBooks".equals(type)) {
            // 查询所有图书
            selectAllBooks(request, response);
        }

        else if ("selectBookName".equals(type)) {
            //按书名查询
            selectBookName(request, response);
        }

        else if ("selectAuthor".equals(type)) {
            // 按作者名查询
            selectAuthor(request, response);
        }

        else if ("delete".equals(type)) {
            // 删除书籍
            delete(request, response);
        }
        else if ("queryBooks".equals(type)){
            //模糊查询，查询出搜索框中的内容，不论是作者名还是书名。
            queryBooks(request,response);
        }
        else if ("updateBooks".equals(type)){
            //修改当前这本书的信息
            updateBooks(request,response);
        }
        else if ("home".equals(type)) {
            // 跳转主页
            home(request, response);
        }

    }

    //修改当前图书的信息
    private void updateBooks(HttpServletRequest request, HttpServletResponse response) {
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookNo = req.getParameter("bookNo");
        String bookName = req.getParameter ("bookName");
        String author = req.getParameter("author");
        String publish = req.getParameter("publish");
        String publishTime = req.getParameter("publishTime");
        String price = req.getParameter("price");
        Book book = new Book(bookNo, bookName, author, publish, publishTime, price);
        req.setAttribute("statue", bookDao.add(book));
        uri = "/webroot/newBooks.jsp";
        req.getRequestDispatcher(uri).forward(req, resp);
    }

    public void selectAllBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("bookList",bookDao.selectAll());
        uri = "/webroot/selectAllBooks.jsp";
        req.getRequestDispatcher(uri).forward(req, resp);
    }

    public void selectBookName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String bookName = req.getParameter ("bookName");
        Book book = new Book();
        book.setBookName(bookName);
        req.setAttribute("bookList",bookDao.selectBookName(book.getBookName()));
//        uri = "/webroot/selectBookName.jsp";
        uri = "/webroot/selectAllBooks.jsp";
        req.getRequestDispatcher(uri).forward(req, resp);
    }

    public void selectAuthor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String author = req.getParameter("author");
        System.out.println(author);
        req.setAttribute("bookList",bookDao.selectAuthor(author));
        uri = "/webroot/selectAllBooks.jsp";
        req.getRequestDispatcher(uri).forward(req, resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookName = req.getParameter("bookName");
        req.setAttribute("statue", bookDao.delete(bookName));
        uri = "/webroot/deleteBooks.jsp";
        req.getRequestDispatcher(uri).forward(req, resp);
    }


    public void queryBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String target = req.getParameter("target");
        req.setAttribute("authorList",bookDao.selectAuthor(target));
        req.setAttribute("bookNameList",bookDao.selectBookName(target));
        uri = "/webroot/selectAllBooks.jsp";
        req.getRequestDispatcher(uri).forward(req, resp);
    }


    public void home(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        uri = "/webroot/home.jsp";
        req.getRequestDispatcher(uri).forward(req, resp);
    }




}
