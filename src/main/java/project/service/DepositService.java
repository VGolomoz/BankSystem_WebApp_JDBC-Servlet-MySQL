package project.service;

import org.apache.log4j.Logger;
import project.DAO.interfaces.DepositAccDAO;
import project.DAO.interfaces.FactoryDAO;
import project.DAO.interfaces.UserAccDAO;
import project.model.entities.DepositAccount;
import project.model.entities.User;

public class DepositService {

    private FactoryDAO factoryDAO = FactoryDAO.getInstance();
    private static final Logger LOG = Logger.getLogger(DepositService.class);

    public void createDepositAccountInDatabase(DepositAccount depositAccount) {

        DepositAccDAO depositAccDAO = factoryDAO.createDepositAccDAO();
        depositAccDAO.create(depositAccount);
    }

    public DepositAccount getDepositAccountFromDB (User user){
        DepositAccDAO depositAccDAO = factoryDAO.createDepositAccDAO();
        DepositAccount depositAccount = depositAccDAO.getById(user.getUserId());
        return depositAccount;
    }

    public void updateUserAccDepositStatus (User user) {
        UserAccDAO userAccDAO = factoryDAO.createUserAccDAO();
        userAccDAO.updateDepositStatusById(user.getUserId());
    }
}
