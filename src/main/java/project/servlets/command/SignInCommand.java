package project.servlets.command;

import org.apache.log4j.Logger;
import project.model.entities.User;
import project.service.UserService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SignInCommand implements Command {

    private final Logger LOG = Logger.getLogger(SignInCommand.class);
    private UserService userService;

    public SignInCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String command = "/views/signIn.jsp";
        String mail = request.getParameter("mail");
        User user = userService.getUserIfExist(mail);

        if (user != null) {

            LOG.info("Sign In Succesfull");
            request.getSession().setAttribute("loginedUser", user);
            request.getSession().setAttribute("userAccount", userService.getUserAccountFromDB(user));
            request.getSession().setAttribute("contactDetails", userService.getContactDetailsFromDB(user));

            command = "/views/client.jsp";
        } else {
            LOG.info("Unknown login, try again");
            request.setAttribute("userName", "Unknown login, try again");
        }

        return command;
    }
}
