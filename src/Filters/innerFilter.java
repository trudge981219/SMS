package Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "innerFilter")
public class innerFilter implements javax.servlet.Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession(false);
        HttpServletResponse response = (HttpServletResponse) resp;

        if (session==null||!session.getAttribute("num").equals(request.getParameter("num"))) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }

        chain.doFilter(req, resp);
    }
}
