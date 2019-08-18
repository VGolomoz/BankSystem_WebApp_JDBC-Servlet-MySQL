package project.service.paymentCommand;

import org.apache.log4j.Logger;
import project.DAO.interfaces.FactoryDAO;
import project.DAO.interfaces.OpTransferDAO;
import project.DAO.interfaces.UserAccDAO;
import project.DAO.interfaces.UserDAO;
import project.model.OpTransfer;
import project.model.UserAccount;
import project.util.enums.OperationTypes;
import project.util.myExceptions.UnsupportedPaymentException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpTransferCommand implements PaymentCommand {

    private final Logger LOGGER = Logger.getLogger(OpTransferCommand.class);
    private FactoryDAO factoryDAO = FactoryDAO.getInstance();

    private PaymentCommand next;
    private int recipientId;

    @Override
    public void setNext(PaymentCommand next) {
        this.next = next;
    }

    @Override
    public String makePayment(HttpServletRequest request, HttpServletResponse response) throws UnsupportedPaymentException {

        String result;

        final String operationId = request.getParameter("operationId");

        if (isSupportPayment(operationId)) {
            LOGGER.info("There is Operation Transfer started");
            final int userId = (Integer) request.getSession().getAttribute("userId");
            final String recipientMail = request.getParameter("recipientMail");
            final float amount = Float.valueOf(request.getParameter("amount"));

            if (isRecipientExist(recipientMail)) {
                if (updateUserAccBalance(userId, recipientId, amount)) {
                    addToOperationHistory(userId, recipientMail, amount);
                    result = "Operation Successful";
                } else {
                    result = "Not enough money!";
                }
            } else {
                result = "Client with that email does not exist";
            }
        } else {
            if (this.next == null) throw new UnsupportedPaymentException("Not supporting payment operation");
            else {
                LOGGER.info("There is not Operation Transfer, try next");
                result = this.next.makePayment(request, response);
            }
        }
        return result;
    }

    @Override
    public boolean isSupportPayment(String operationId) {
        if (operationId.equals(OperationTypes.TRANSFER.getTitle()))
            return true;
        else return false;
    }

    private boolean isRecipientExist(String mail) {
        LOGGER.info("Check if recipient Account exist");
        UserDAO userDAO = factoryDAO.createUserDAO();
        if (userDAO.isUserExists(mail)) {
            recipientId = userDAO.getUserIdByMail(mail);
            return true;
        } else return false;
    }

    private boolean updateUserAccBalance(int userId, int recipientId, float amount) {
        UserAccDAO userAccDAO = factoryDAO.createUserAccDAO();
        UserAccount userAccount = userAccDAO.getById(userId);
        LOGGER.info("Check User Account Balance for enough money");
        if (userAccount.getBalance() >= amount) {
            final float newBalance = userAccount.getBalance() - amount;
            userAccDAO.updateBalanceById(userId, newBalance);
            LOGGER.info("User Account Balance updated");

            userAccount = userAccDAO.getById(recipientId);
            final float newRecipientBalance = userAccount.getBalance() + amount;
            userAccDAO.updateBalanceById(recipientId, newRecipientBalance);
            LOGGER.info("Recipient Account Balance updated");
            return true;
        } else return false;
    }

    private void addToOperationHistory(int userId, String recipientMail, float amount) {
        OpTransfer opTransfer = new OpTransfer();
        opTransfer.setUserId(userId);
        opTransfer.setRecipientMail(recipientMail);
        opTransfer.setAmount(amount);

        OpTransferDAO opTransferDAO = factoryDAO.createOpTransferDAO();
        opTransferDAO.create(opTransfer);
        LOGGER.info("Operation Transfer added to operation history");
    }
}
