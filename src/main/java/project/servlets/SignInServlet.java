package project.servlets;


import org.apache.log4j.Logger;
import project.model.User;
import project.util.enums.Role;
import project.service.UserService;
import project.util.myExceptions.WrongPasswordException;

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
        String command = "views/signIn.jsp";

        LOGGER.info("Check session and permission");
        if (request.getSession() != null && request.getSession().getAttribute("userId") != null){
            int roleId = (Integer) request.getSession().getAttribute("roleId");
            if (roleId == Role.CLIENT.getRoleId()) command = "/client";
            else if (roleId == Role.MANAGER.getRoleId()) command = "/manager";
            else if (roleId == Role.ADMIN.getRoleId()) command = "/admin";
            LOGGER.info("Permission checked, go to " + command + " page");
            response.sendRedirect(command);
        } else request.getRequestDispatcher(command).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("SignInServlet call doPost() method");
        User user;
        int userId;
        int roleId;
        UserService userService = new UserService();
        String command = "/signIn";
        String mail = request.getParameter("mail");
        String pass = request.getParameter("pass");

        if (userService.isUserExist(mail)) {
            LOGGER.info("User exist, check password");
            try {
                user = userService.getUser(mail, pass);
                userId = user.getUserId();
                roleId = user.getRoleId();
                request.getSession().setAttribute("userId", userId);
                request.getSession().setAttribute("roleId", roleId);
                LOGGER.info("Password correct");
                if (roleId == Role.CLIENT.getRoleId()) command = "/client";
                else if (roleId == Role.MANAGER.getRoleId()) command = "/manager";
                else if (roleId == Role.ADMIN.getRoleId()) command = "/admin";
            } catch (WrongPasswordException e) {
                LOGGER.info("Password incorrect");
                request.getSession().setAttribute("wrongData", "Wrong password, try again");
            }

        } else {
            LOGGER.info("Unknown login");
            request.getSession().setAttribute("wrongData", "Wrong login, try again or use registration");

        }
        response.sendRedirect(command);
    }
}
