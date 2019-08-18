package project.service;

import org.apache.log4j.Logger;
import project.DAO.interfaces.ContactDetailsDAO;
import project.DAO.interfaces.FactoryDAO;
import project.DAO.interfaces.UserAccDAO;
import project.DAO.interfaces.UserDAO;
import project.model.ContactDetails;
import project.model.User;
import project.model.UserAccount;
import project.util.myExceptions.WrongPasswordException;


public class UserService {

    private FactoryDAO factoryDAO = FactoryDAO.getInstance();
    private static final Logger LOG = Logger.getLogger(UserService.class);

    public boolean isUserExist(String mail) {
        UserDAO dao = factoryDAO.createUserDAO();
        if (dao.isUserExists(mail)) return true;
        else return false;
    }

    public User getUser(String mail, String pass) throws WrongPasswordException {

        UserDAO dao = factoryDAO.createUserDAO();
        return dao.getUserByMailAndPass(mail, pass);
    }

    public UserAccount getUserAccountFromDB (int id){
        UserAccDAO userAccDAO = factoryDAO.createUserAccDAO();
        UserAccount userAccount = userAccDAO.getById(id);
        return userAccount;
    }

    public ContactDetails getContactDetailsFromDB (int id){
        ContactDetailsDAO contactDetailsDAO = factoryDAO.createContactDetailsDAO();
        ContactDetails contactDetails = contactDetailsDAO.getById(id);
        return contactDetails;
    }

    public void createUserInDatabase(User user) {

        UserDAO dao = factoryDAO.createUserDAO();
        dao.create(user);
        user.setUserId(dao.getUserIdByMail(user.getMail()));
    }

    public void createUserAccInDatabase(UserAccount userAccount){
        UserAccDAO dao = factoryDAO.createUserAccDAO();
        dao.create(userAccount);
    }

    public void createContactDetailsInDatabase(ContactDetails contactDetails){
        ContactDetailsDAO dao = factoryDAO.createContactDetailsDAO();
        dao.create(contactDetails);
    }


}

