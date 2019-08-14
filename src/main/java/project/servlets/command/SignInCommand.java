package project.servlets.command;

import org.apache.log4j.Logger;
import project.model.entities.User;
import project.model.enums.Role;
import project.service.UserService;
import project.util.MyExceptions.WrongPasswordException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SignInCommand implements Command {

    private final Logger LOG = Logger.getLogger(SignInCommand.class);
    private UserService userService;
    private int userId;
    private int roleId;

    public SignInCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        User user;
        String command = "/views/signIn.jsp";
        String mail = request.getParameter("mail");
        String pass = request.getParameter("pass");

        if (userService.isUserExist(mail)) {
            LOG.info("User exist, check password");
            try {
                user = userService.getUser(mail, pass);
                userId = user.getUserId();
                roleId = Role.CLIENT.getRoleId();
                request.getSession().setAttribute("userId", userId);
                request.getSession().setAttribute("roleId", roleId);
                LOG.info("Password correct");
                command = "/home.jsp";
            } catch (WrongPasswordException e) {
                LOG.info("Password incorrect");
                request.setAttribute("wrongData", "Wrong password, try again");
            }

        } else {
            LOG.info("Unknown login");
            request.setAttribute("wrongData", "Wrong login, try again or use registration");

        }
        return command;
    }
}
