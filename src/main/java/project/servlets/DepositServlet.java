package project.servlets;

import org.apache.log4j.Logger;
import project.service.DepositService;
import project.service.UserService;
import project.servlets.command.DepositCommand;
import project.servlets.command.OpenDepositCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DepositServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(DepositServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("DepositServlet call doGet() method");
        String path = new DepositCommand(new DepositService()).execute(request, response);
        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("DepositServlet call doPost() method");
        String path = new OpenDepositCommand(new DepositService()).execute(request, response);
        request.getRequestDispatcher(path).forward(request, response);
    }
}
