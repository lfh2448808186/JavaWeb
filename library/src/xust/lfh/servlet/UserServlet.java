package xust.lfh.servlet;

import xust.lfh.Bean.Admin;
import xust.lfh.Bean.User;
import xust.lfh.Dao.AdminDao;
import xust.lfh.Dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/User")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 获取操作的类型
        String type = request.getParameter("type");

        // 判断
        if ("login".equals(type)) {
            // 进行登陆
          login(request, response);
        }

        else if ("register".equals(type)) {
            // 用户注册
            register(request, response);
        }

        else if ("loginOut".equals(type)) {
            // 退出登录
            loginOut(request, response);
        }

    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session  = req.getSession();
        String identity = req.getParameter("id");
        String user = req.getParameter("username");
        String password =req.getParameter("password");
        RequestDispatcher dispatcher = req.getRequestDispatcher("webroot/home.jsp");

        if (identity.equals("admin")){
            AdminDao adminDao = new AdminDao();
            try {
                List<Admin> list = adminDao.select(user);
                if(list!=null&&list.size()>0){
                    Admin admin = list.get(0);
                    if ((admin.getAdminName().equals(user))&&(admin.getAdminPassword().equals(password))){
                        req.setAttribute("identity",identity);
                        session.setAttribute("user",user);
                        dispatcher.forward(req,resp);
                    }else{
                        resp.sendRedirect("index.jsp");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                UserDao userDao = new UserDao();
                List<User> list = userDao.select(user);
                if(list!=null&&list.size()>0){
                    User user1 = list.get(0);
                    if ((user1.getUserName().equals(user))&&(user1.getUserPassword().equals(password))){
                        req.setAttribute("identity",identity);
                        session.setAttribute("user",user);
                        dispatcher.forward(req,resp);
                    }else{
                        resp.sendRedirect("index.jsp");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String password =req.getParameter("password");
        UserDao userDao = new UserDao();
        try {
            User user1 = new User();
            user1.setUserName(user);
            user1.setUserPassword(password);
            req.setAttribute("statue",userDao.addUser(user1));
            resp.sendRedirect("index.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loginOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session  = req.getSession();
        session.removeAttribute("user");
        String uri = "index.jsp";
        req.getRequestDispatcher(uri).forward(req, resp);

    }
}
