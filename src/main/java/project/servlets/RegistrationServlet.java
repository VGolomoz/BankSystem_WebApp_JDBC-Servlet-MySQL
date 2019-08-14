package project.servlets;


import org.apache.log4j.Logger;
import project.service.UserService;
import project.servlets.command.RegistrUserCommand;
import project.servlets.command.RegistrationCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RegistrationServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(RegistrationServlet.class);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("RegistrationServlet call doGet() method");
        request.getRequestDispatcher(new RegistrUserCommand().execute(request, response)).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("RegistrationServlet call doPost() method");
        String path = new RegistrationCommand(new UserService()).execute(request, response);
        /*request.getRequestDispatcher(path).forward(request, response);*/
        response.sendRedirect(path);
    }


}



