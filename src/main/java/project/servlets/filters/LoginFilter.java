package project.servlets.filters;

import org.apache.log4j.Logger;
import project.util.enums.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginFilter implements Filter {

    private final Logger LOGGER = Logger.getLogger(LoginFilter.class);
    List<String> clientURL;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        clientURL = new ArrayList<>();
        clientURL.add("/client");
        clientURL.add("/deposit");
        clientURL.add("/open_deposit");
        clientURL.add("/operations");
        clientURL.add("/signIn");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(true);

        String path = request.getServletPath();

        LOGGER.info("Check session");
        LOGGER.info("Servlet path " + path);

        if ((session.getAttribute("userId") != null) && !path.equals("/logout")) {
            LOGGER.info("User is logined");
            int roleId = (Integer) request.getSession().getAttribute("roleId");
            if (roleId == Role.CLIENT.getRoleId() && clientURL.contains(path)) {
                LOGGER.info("Role - Client, go to client's page");
                filterChain.doFilter(request, response);

            } else if (roleId == Role.MANAGER.getRoleId()) {
                LOGGER.info("Role - Manager, go to manager page");
                filterChain.doFilter(request, response);

            } else if (roleId == Role.ADMIN.getRoleId()) {
                LOGGER.info("Role - Admin, go to admin page");
                filterChain.doFilter(request, response);
            }
        } else {
            if (path.equals("/signIn") || path.equals("/registration") || path.equals("/logout"))
                request.getRequestDispatcher(path).forward(request, response);
            else { path = "/home.jsp";
                request.getRequestDispatcher(path).forward(request, response);
            }
        }
    }

        /*if (!path.equals("/home") && !path.equals("/home.jsp")) {

            if (clientURL.contains(path) && session.getAttribute("userId") != null) {
                LOGGER.info("User is logined");
                int roleId = (Integer) request.getSession().getAttribute("roleId");
                if (roleId == Role.CLIENT.getRoleId() && clientURL.contains(path)) {
                    LOGGER.info("Role - Client, go to client's page");
                    filterChain.doFilter(request, response);

                } else if (roleId == Role.MANAGER.getRoleId()) {
                    LOGGER.info("Role - Manager, go to manager page");
                    filterChain.doFilter(request, response);

                } else if (roleId == Role.ADMIN.getRoleId()) {
                    LOGGER.info("Role - Admin, go to admin page");
                    filterChain.doFilter(request, response);
                }
            } else {
                LOGGER.info("Not logged in or logout, redirect to home.jsp");
                request.getRequestDispatcher("/signIn").forward(request, response);
            }
        } else request.getRequestDispatcher("/home.jsp").forward(request, response);*/

    @Override
    public void destroy() {

    }
}
