package project.service;

import org.apache.log4j.Logger;
import project.DAO.interfaces.CreditAccDAO;
import project.DAO.interfaces.FactoryDAO;
import project.DAO.interfaces.UserAccDAO;
import project.model.CreditAccount;

public class CreditService {

    private FactoryDAO factoryDAO = FactoryDAO.getInstance();
    private static final Logger LOG = Logger.getLogger(CreditService.class);

    public void createCreditAccountInDatabase(CreditAccount creditAccount) {
        LOG.info("create Credit Account in DB");
        CreditAccDAO creditAccDAO = factoryDAO.createCreditAccDAO();
        creditAccDAO.create(creditAccount);
    }

    public CreditAccount getCreditAccountFromDB (int id){
        LOG.info("get Credit Account from DB");
        CreditAccDAO creditAccDAO = factoryDAO.createCreditAccDAO();
        CreditAccount creditAccount = creditAccDAO.getById(id);
        return creditAccount;
    }

    public void updateUserAccCreditStatus (int id) {
        LOG.info("update User Account Credit Status");
        UserAccDAO userAccDAO = factoryDAO.createUserAccDAO();
        userAccDAO.updateCreditStatusById(id);
    }
}
