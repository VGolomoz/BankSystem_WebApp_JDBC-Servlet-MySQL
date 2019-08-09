package project.service;

import org.apache.log4j.Logger;
import project.DAO.interfaces.ContactDetailsDAO;
import project.DAO.interfaces.FactoryDAO;
import project.DAO.interfaces.UserAccDAO;
import project.DAO.interfaces.UserDAO;
import project.model.entities.ContactDetails;
import project.model.entities.User;
import project.model.entities.UserAccount;




public class UserService {

    private FactoryDAO factoryDAO = FactoryDAO.getInstance();
    private static final Logger LOG = Logger.getLogger(UserService.class);

    public User checkIsUserExist (String mail) {
        User user;
        UserDAO dao = factoryDAO.createUserDAO();
        if (dao.isUserExists(mail)) {
           user = dao.getById(dao.getUserIdByMail(mail));
          return user;
        }
        else return null;
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

