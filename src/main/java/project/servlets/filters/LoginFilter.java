package project.servlets.filters;

import org.apache.log4j.Logger;
import project.model.enums.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    private final Logger LOGGER = Logger.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(true);


        LOGGER.info("Check session");
        if (session.getAttribute("userId") != null) {
            LOGGER.info("User is logined");
            int roleId = (Integer) request.getSession().getAttribute("roleId");
            if (roleId == Role.CLIENT.getRoleId()) {
                LOGGER.info("Role - Client, go to client page");
                request.getRequestDispatcher("/client").forward(request, response);
            } else if (roleId == Role.MANAGER.getRoleId()) {
                LOGGER.info("Role - Manager, go to manager page");
                request.getRequestDispatcher("/manager").forward(request, response);
                filterChain.doFilter(request, response);
            } else if (roleId == Role.ADMIN.getRoleId()){
                LOGGER.info("Role - Admin, go to admin page");
                request.getRequestDispatcher("/admin").forward(request, response);
                filterChain.doFilter(request, response);
            }
        } else {
            LOGGER.info("Not logged in,continue");
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
