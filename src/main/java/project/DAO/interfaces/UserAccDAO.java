package project.DAO.interfaces;

import project.model.entities.UserAccount;

public interface UserAccDAO extends DAO<UserAccount> {

   void updateDepositStatusById(int id);

}
