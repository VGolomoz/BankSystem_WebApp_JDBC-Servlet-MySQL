package project.servlets;

import org.apache.log4j.Logger;
import project.model.ContactDetails;
import project.model.UserAccount;
import project.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(ClientServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("ClientServlet call doGet() method");

        UserService userService = new UserService();
        int userId = (Integer) request.getSession().getAttribute("userId");

        LOGGER.info("Create UserAccount and ContactDetails objects from DB");
        UserAccount userAccount = userService.getUserAccountFromDB(userId);
        ContactDetails contactDetails = userService.getContactDetailsFromDB(userId);

        LOGGER.info("Set session attributes and get client page");
        request.getSession().setAttribute("userAccount", userAccount);
        request.getSession().setAttribute("contactDetails", contactDetails);

        request.getRequestDispatcher("/views/client/client.jsp").forward(request, response);
    }
}
