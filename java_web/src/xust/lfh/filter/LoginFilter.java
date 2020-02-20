package xust.lfh.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1.排除登陆相关的资源，是放行；
 *          不是判：断是否登录
 *
 *          2.判断当前用户是否登陆，判断Session中是否由User
 *              有：登陆成功，
 *              没有：返回登陆
 */
@WebFilter( "/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse)resp;
        //1.获取资源请求路径
        String uri = request.getRequestURI();
        //2.判断是否包含登陆相关资源
        if(/*uri.contains("/login.jsp")||*/ uri.contains("/loginServlet")||uri.contains("/CheckCodeServlet")|| uri.contains("/resource")||
                uri.contains("/userRegisterServlet")||uri.contains("addUser.jsp")){
            chain.doFilter(req, resp);
        }else{
            //3.从Session中获取user
            Object user = request.getSession().getAttribute("username");
            if (user !=null){
                chain.doFilter(req,resp);
            }else{
                request.setAttribute("login_msg","您还未登录，请登录");
                request.getRequestDispatcher("index.jsp").forward(request,resp);
            }
        }
        //
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
