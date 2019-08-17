package project.servlets;


import org.apache.log4j.Logger;
import project.model.ContactDetails;
import project.model.User;
import project.model.UserAccount;
import project.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


public class RegistrationServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(RegistrationServlet.class);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("RegistrationServlet call doGet() method");
        request.getRequestDispatcher("views/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("RegistrationServlet call doPost() method");

        LOGGER.info("Create new user in DB");
        UserService userService = new UserService();
        User user = new User();
        user.setMail(request.getParameter("mail"));
        user.setPass(request.getParameter("pass"));
        userService.createUserInDatabase(user);

        LOGGER.info("Create new user account in DB");
        UserAccount userAccount = new UserAccount();
        userAccount.setUserId(user.getUserId());
        userAccount.setValidity(new Date(2019, 10, 05));
        userService.createUserAccInDatabase(userAccount);

        LOGGER.info("Create new contact details in DB");
        ContactDetails contactDetails = new ContactDetails();
        contactDetails.setUserId(user.getUserId());
        contactDetails.setMail(user.getMail());
        contactDetails.setName(request.getParameter("name"));
        contactDetails.setLastName(request.getParameter("lastname"));
        contactDetails.setAddress(request.getParameter("address"));
        contactDetails.setMobilePhone(request.getParameter("mobile_phone"));
        contactDetails.setBirthday(Date.valueOf(request.getParameter("birthday")));
        userService.createContactDetailsInDatabase(contactDetails);

        request.getSession().setAttribute("userName", contactDetails.getName() + " registration is done");

        LOGGER.info("Registration Successful, return to SignIn page");

        response.sendRedirect("/signIn");
    }


}



