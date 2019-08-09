package project.DAO.interfaces;

import project.model.entities.User;

public interface UserDAO extends DAO<User> {

    boolean isUserExists(String mail);

    int getUserIdByMail(String mail);

}
