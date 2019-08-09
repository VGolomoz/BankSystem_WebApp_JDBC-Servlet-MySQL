package project.servlets.command;

import org.apache.log4j.Logger;
import project.model.entities.ContactDetails;
import project.model.entities.User;
import project.model.entities.UserAccount;
import project.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


public class RegistrationCommand implements Command {

    private final Logger LOGGER = Logger.getLogger(RegistrationCommand.class);
    private UserService userService;

    public RegistrationCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        User user = new User();
        user.setMail(request.getParameter("mail"));
        user.setPass(request.getParameter("pass"));
        userService.createUserInDatabase(user);

        UserAccount userAccount = new UserAccount();
        userAccount.setUserId(user.getUserId());
        userAccount.setValidity(new Date(2019, 10, 05));
        userService.createUserAccInDatabase(userAccount);

        ContactDetails contactDetails = new ContactDetails();
        contactDetails.setUserId(user.getUserId());
        contactDetails.setMail(user.getMail());
        contactDetails.setName(request.getParameter("name"));
        contactDetails.setLastName(request.getParameter("lastname"));
        contactDetails.setAddress(request.getParameter("address"));
        contactDetails.setMobile_phone(request.getParameter("mobile_phone"));
        contactDetails.setBirthday(Date.valueOf(request.getParameter("birthday")));
        userService.createContactDetailsInDatabase(contactDetails);


        LOGGER.info("return SignIn page");
        return "views/signIn.jsp";
    }
}
