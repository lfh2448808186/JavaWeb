package xust.lfh.servlet;

import xust.lfh.dao.UserDao;
import xust.lfh.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(urlPatterns = "/userRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password =request.getParameter("password");
        UserDao userDao = new UserDao();
        User user1 = new User();
        user1.setUsername(username);
        user1.setPassword(password);
        request.setAttribute("statue",userDao.addUser(user1));
        response.sendRedirect(request.getContextPath()+"index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
