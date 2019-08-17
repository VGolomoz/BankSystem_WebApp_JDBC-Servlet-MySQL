package project.service;

import org.apache.log4j.Logger;
import project.DAO.interfaces.DepositAccDAO;
import project.DAO.interfaces.FactoryDAO;
import project.DAO.interfaces.UserAccDAO;
import project.model.DepositAccount;

public class DepositService {

    private FactoryDAO factoryDAO = FactoryDAO.getInstance();
    private static final Logger LOG = Logger.getLogger(DepositService.class);

    public void createDepositAccountInDatabase(DepositAccount depositAccount) {

        DepositAccDAO depositAccDAO = factoryDAO.createDepositAccDAO();
        depositAccDAO.create(depositAccount);
    }

    public DepositAccount getDepositAccountFromDB (int id){
        DepositAccDAO depositAccDAO = factoryDAO.createDepositAccDAO();
        DepositAccount depositAccount = depositAccDAO.getById(id);
        return depositAccount;
    }

    public void updateUserAccDepositStatus (int id) {
        UserAccDAO userAccDAO = factoryDAO.createUserAccDAO();
        userAccDAO.updateDepositStatusById(id);
    }
}
