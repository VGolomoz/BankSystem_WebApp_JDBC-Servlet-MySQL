package project.DAO.interfaces;

import project.model.User;
import project.util.MyExceptions.WrongPasswordException;

public interface UserDAO extends DAO<User> {

    boolean isUserExists(String mail);

    User getUserByMailAndPass(String mail, String pass) throws WrongPasswordException;

    int getUserIdByMail(String mail);

}
