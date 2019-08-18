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
        LOG.info("create Deposit Account in DB");
        DepositAccDAO depositAccDAO = factoryDAO.createDepositAccDAO();
        depositAccDAO.create(depositAccount);
    }

    public DepositAccount getDepositAccountFromDB (int id){
        LOG.info("get Deposit Account from DB");
        DepositAccDAO depositAccDAO = factoryDAO.createDepositAccDAO();
        DepositAccount depositAccount = depositAccDAO.getById(id);
        return depositAccount;
    }

    public void updateUserAccDepositStatus (int id) {
        LOG.info("update User Account Deposit Status");
        UserAccDAO userAccDAO = factoryDAO.createUserAccDAO();
        userAccDAO.updateDepositStatusById(id);
    }
}
