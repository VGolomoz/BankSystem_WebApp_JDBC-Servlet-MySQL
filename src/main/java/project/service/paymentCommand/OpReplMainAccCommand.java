package project.service.paymentCommand;

import org.apache.log4j.Logger;
import project.DAO.interfaces.FactoryDAO;
import project.DAO.interfaces.OpReplenishmentDAO;
import project.DAO.interfaces.UserAccDAO;
import project.model.OpReplenishment;
import project.model.UserAccount;
import project.util.enums.OperationTypes;
import project.util.myExceptions.UnsupportedPaymentException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpReplMainAccCommand implements PaymentCommand {

    private final Logger LOGGER = Logger.getLogger(OpReplMainAccCommand.class);
    private FactoryDAO factoryDAO = FactoryDAO.getInstance();

    private PaymentCommand next;

    @Override
    public void setNext(PaymentCommand next) {
        this.next = next;
    }

    @Override
    public String makePayment(HttpServletRequest request, HttpServletResponse response) throws UnsupportedPaymentException {

        String result;

        final String operationId = request.getParameter("operationId");

        if (isSupportPayment(operationId)) {
            LOGGER.info("There is Operation Replenishment Main Account Balance started");
            final int userId = (Integer) request.getSession().getAttribute("userId");
            final float amount = Float.valueOf(request.getParameter("amount"));

            updateUserAccBalance(userId, amount);
            addToOperationHistory(userId, amount);
            result = "Operation Successful";
        } else {
            if (this.next == null) throw new UnsupportedPaymentException("Not supporting payment operation");
            else {
                LOGGER.info("There is not Replenishment Main Account Payment, try next");
                result = this.next.makePayment(request, response);
            }
        }
        return result;
    }

    @Override
    public boolean isSupportPayment(String operationId) {
        if (operationId.equals(OperationTypes.REPL_MAIN_ACC.getTitle()))
            return true;
        else return false;
    }

    private void updateUserAccBalance(int userId, float amount) {
        UserAccDAO userAccDAO = factoryDAO.createUserAccDAO();
        UserAccount userAccount = userAccDAO.getById(userId);
        LOGGER.info("Try to update Main User Account Balance");
        final float newBalance = userAccount.getBalance() + amount;
        userAccDAO.updateBalanceById(userId, newBalance);
        LOGGER.info("Main User Account Balance updated");
        }

    private void addToOperationHistory(int userId,float amount) {
        OpReplenishmentDAO opReplenishmentDAO = factoryDAO.createOpReplenishmentDAO();
        OpReplenishment opReplenishment = new OpReplenishment();
        opReplenishment.setUserId(userId);
        opReplenishment.setAccName("MainAcc");
        opReplenishment.setAmount(amount);
        opReplenishmentDAO.create(opReplenishment);
        LOGGER.info("Operation Replenishment Main Account added to operation history");
    }
}
