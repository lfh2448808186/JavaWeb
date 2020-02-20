package xust.lfh.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.LogRecord;


public class LoginFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String url = request.getRequestURI();
        if (url.endsWith("login.jsp") !=true) {
            if (username == null || " ".equals(username)) {
                response.sendRedirect("login.jsp");
            }else{
                filterChain.doFilter(request,response);
            }
        }

    }

}
