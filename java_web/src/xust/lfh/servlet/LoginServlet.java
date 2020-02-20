package xust.lfh.servlet;


import org.apache.commons.beanutils.BeanUtils;
import xust.lfh.dao.UserDao;
import xust.lfh.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


/*
    判断用户输入的验证码和程序生成的验证码是否一致
    在session中获取后台生成的验证码；信息一致继续
        信息不一致：提示错误信息：并且转发到登陆页面跳转
 */

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("html/txt;utf-8");
        //2.获取前台参数
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        //3.将信息保存在对象中
//        User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);
        //2.
        String checkCode = req.getParameter("checkCode");//获取前台输入验证码
        HttpSession session = req.getSession();
        String checkCode_session = (String)session.getAttribute("checkCode_session");//页面打开后产生验证码，获取session
        session.removeAttribute("checkCode_session");//对于验证码的session可以删除了
        /**
         * 如果验证码符合了继续进行验证用户名和密码
         */
        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)){
            Map<String, String[]> map = req.getParameterMap();
            //3.信息封装
            User loginUser = new User();
            try {
                BeanUtils.populate(loginUser,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        /*
          4.将对象传进Dao层进行查询；
                并且将查询到的对象进行返回；
         */
            UserDao dao = new UserDao();
            User user = dao.login(loginUser);
            //5.判断用户是否为空.
            if (user == null){
                req.setAttribute("login_error","用户名或密码错误");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }else{
                session.setAttribute("username",user.getUsername());
                resp.sendRedirect(req.getContextPath()+"/webroot/home.jsp");
            }
        }else{
            req.setAttribute("cc_error","验证码错误");
            req.getRequestDispatcher("index.jsp").forward(req,resp);

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }
}
