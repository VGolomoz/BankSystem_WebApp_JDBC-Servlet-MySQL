package project.DAO.interfaces;

import org.apache.log4j.Logger;
import project.DAO.implementations.FactoryJDBC;

public abstract class FactoryDAO {

    private static FactoryDAO factoryDAO;
    private static final Logger LOG = Logger.getLogger(FactoryDAO.class);

    public abstract UserDAO createUserDAO();

    public abstract UserAccDAO createUserAccDAO();

    public abstract ContactDetailsDAO createContactDetailsDAO();

    public abstract DepositAccDAO createDepositAccDAO();

    public abstract CreditAccDAO createCreditAccDAO();

    public abstract OpCreditProofDAO createOpCreditProofDAO();

    public abstract OpBillPaymentDAO createOpBillPaymentDAO();

    public abstract OpTransferDAO createOpTransferDAO();

    public abstract OpReplenishmentDAO createOpReplenishmentDAO();



    public static FactoryDAO getInstance() {
        if (factoryDAO == null) {
            synchronized (FactoryDAO.class) {
                if (factoryDAO == null) {
                    LOG.debug("Creating  FactoryDAO");
                    factoryDAO = new FactoryJDBC();
                }
            }
        }
        return factoryDAO;
    }
}
