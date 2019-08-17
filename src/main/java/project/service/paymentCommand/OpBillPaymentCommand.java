package project.service.paymentCommand;

import org.apache.log4j.Logger;
import project.DAO.interfaces.FactoryDAO;
import project.DAO.interfaces.OpBillPaymentDAO;
import project.DAO.interfaces.UserAccDAO;
import project.model.OpBillPayment;
import project.model.UserAccount;
import project.util.enums.OperationTypes;
import project.util.MyExceptions.UnsupportedPaymentException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpBillPaymentCommand implements PaymentCommand {

    private final Logger LOGGER = Logger.getLogger(OpBillPaymentCommand.class);
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
            LOGGER.info("There is Operation Bill Payment started");
            final int userId = (Integer) request.getSession().getAttribute("userId");
            final String billNumber = request.getParameter("billNumber");
            final String purpose = request.getParameter("purpose");
            final float amount = Float.valueOf(request.getParameter("amount"));

            if (updateUserAccBalance(userId, amount)) {
                addToOperationHistory(userId, billNumber, purpose, amount);
                result = "Operation Successful";
            } else {
                result = "Not enough money!";
            }

        } else {
            if (this.next == null) throw new UnsupportedPaymentException("Not supporting payment operation");
            else {
                LOGGER.info("There is not Operation Bill Payment, try next");
                result = this.next.makePayment(request, response);
            }
        }
        return result;
    }

    @Override
    public boolean isSupportPayment(String operationId) {
        if (operationId.equals(OperationTypes.BILL_PAYMENT.getTitle()))
            return true;
        else return false;
    }

    private boolean updateUserAccBalance(int userId, float amount) {
        UserAccDAO userAccDAO = factoryDAO.createUserAccDAO();
        UserAccount userAccount = userAccDAO.getById(userId);
        LOGGER.info("Check User Account Balance for enough money");
        if (userAccount.getBalance() >= amount) {
            final float newBalance = userAccount.getBalance() - amount;
            userAccDAO.updateBalanceById(userId, newBalance);
            LOGGER.info("User Account Balance updated");
            return true;
        } else return false;
    }

    private void addToOperationHistory(int userId, String billNumber, String purpose, float amount) {
        OpBillPayment opBillPayment = new OpBillPayment();
        opBillPayment.setUserId(userId);
        opBillPayment.setBillNumber(billNumber);
        opBillPayment.setPurpose(purpose);
        opBillPayment.setAmount(amount);

        OpBillPaymentDAO opBillPaymentDAO = factoryDAO.createOpBillPaymentDAO();
        opBillPaymentDAO.create(opBillPayment);
        LOGGER.info("Operation Bill Payment added to operation history");
    }
}
