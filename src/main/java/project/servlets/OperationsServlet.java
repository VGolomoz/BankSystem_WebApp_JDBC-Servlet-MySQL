package project.servlets;

import org.apache.log4j.Logger;
import project.service.OperationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OperationsServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(OperationsServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("OperationsServlet call doGet() method");
        request.getRequestDispatcher("views/operations.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("OperationsServlet call doPost() method");

        request.setAttribute("opResult", new OperationService().makePayment(request, response));

        request.getRequestDispatcher("views/operations.jsp").forward(request, response);
    }
}
