package project.DAO.implementations;

import org.apache.log4j.Logger;
import project.DAO.interfaces.*;
import java.sql.Connection;


public class FactoryJDBC extends FactoryDAO {

    private static final Logger LOG = Logger.getLogger(FactoryJDBC.class);
    private Connection connection = DBCPDataSource.getConnection();

    @Override
    public UserDAO createUserDAO() {
        return new UserJDBC(connection);
    }

    @Override
    public UserAccDAO createUserAccDAO() {
        return new UserAccJDBC(connection);
    }

    @Override
    public ContactDetailsDAO createContactDetailsDAO() {
        return new ContactDetailsJDBC(connection);
    }

    @Override
    public DepositAccDAO createDepositAccDAO() {
        return new DepositAccJDBC(connection);
    }

    @Override
    public CreditAccDAO createCreditAccDAO() {
        return new CreditAccJDBC(connection);
    }

    @Override
    public OpCreditProofDAO createOpCreditProofDAO() {
        return new OpCreditProofJDBC(connection);
    }

    @Override
    public OpBillPaymentDAO createOpBillPaymentDAO() {
        return new OpBillPaymentJDBC(connection);
    }

    @Override
    public OpTransferDAO createOpTransferDAO() {
        return new OpTransferJDBC(connection);
    }

    @Override
    public OpReplenishmentDAO createOpReplenishmentDAO() {
        return new OpReplenishmentJDBC(connection);
    }
}
