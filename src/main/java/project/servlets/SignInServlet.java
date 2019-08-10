package project.servlets;


import org.apache.log4j.Logger;
import project.service.UserService;
import project.servlets.command.SignInCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(SignInServlet.class);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("SignInServlet call doGet() method");
        request.getRequestDispatcher("views/signIn.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("SignInServlet call doPost() method");
        String path = new SignInCommand(new UserService()).execute(request, response);
        /*response.sendRedirect(path);*/
        request.getRequestDispatcher(path).forward(request, response);
    }
}
