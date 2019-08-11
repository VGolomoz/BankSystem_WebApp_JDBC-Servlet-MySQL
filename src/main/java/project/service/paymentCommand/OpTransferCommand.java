package project.service.paymentCommand;

import org.apache.log4j.Logger;
import project.DAO.interfaces.FactoryDAO;
import project.DAO.interfaces.OpTransferDAO;
import project.DAO.interfaces.UserAccDAO;
import project.DAO.interfaces.UserDAO;
import project.model.entities.OpTransfer;
import project.model.entities.User;
import project.model.entities.UserAccount;
import project.model.enums.OperationTypes;

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
    public String makePayment(HttpServletRequest request, HttpServletResponse response) {
        String result = "";

        final String operationId = request.getParameter("operationId");

        if (isSupportPayment(operationId)) {
            LOGGER.info("There is Operation Transfer started");
            final User user = (User) request.getSession().getAttribute("loginedUser");
            final String recipientMail = request.getParameter("recipientMail");
            final float amount = Float.valueOf(request.getParameter("amount"));

            if (isRecipientExist(recipientMail)) {
                if (updateUserAccBalance(user, recipientId, amount)) {
                    addToOperationHistory(user, recipientMail, amount);
                    result = "Operation Successful";
                } else {
                    result = "Not enough money!";
                }
            } else {
                result = "Client with that email does not exist";
            }
        } else {
            try {
                LOGGER.info("There is not Operation Bill Payment, try next");
                result = this.next.makePayment(request, response);
            } catch (NullPointerException e) {
                LOGGER.debug("Not supporting payment operation from TransferCommand.class in makePayment() method");
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
        }
        else return false;
    }

    private boolean updateUserAccBalance(User user, int recipientId, float amount) {
        UserAccDAO userAccDAO = factoryDAO.createUserAccDAO();
        UserAccount userAccount = userAccDAO.getById(user.getUserId());
        LOGGER.info("Check User Account Balance for enough money");
        if (userAccount.getBalance() >= amount) {
            final float newBalance = userAccount.getBalance() - amount;
            userAccDAO.updateBalanceById(user.getUserId(), newBalance);
            LOGGER.info("User Account Balance updated");

            userAccount = userAccDAO.getById(recipientId);
            final float newRecipientBalance = userAccount.getBalance() + amount;
            userAccDAO.updateBalanceById(recipientId, newRecipientBalance);
            LOGGER.info("Recipient Account Balance updated");
            return true;
        } else return false;
    }

    private void addToOperationHistory(User user, String recipientMail, float amount) {
        OpTransfer opTransfer = new OpTransfer();
        opTransfer.setUserId(user.getUserId());
        opTransfer.setRecipientMail(recipientMail);
        opTransfer.setAmount(amount);

        OpTransferDAO opTransferDAO = factoryDAO.createOpTransferDAO();
        opTransferDAO.create(opTransfer);
        LOGGER.info("Operation Transfer added to operation history");
    }
}
