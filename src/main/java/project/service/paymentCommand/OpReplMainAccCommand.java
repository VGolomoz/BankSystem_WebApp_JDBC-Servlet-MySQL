package project.service.paymentCommand;

import org.apache.log4j.Logger;
import project.DAO.interfaces.FactoryDAO;
import project.DAO.interfaces.OpReplenishmentDAO;
import project.DAO.interfaces.UserAccDAO;
import project.model.entities.OpReplenishment;
import project.model.entities.User;
import project.model.entities.UserAccount;
import project.model.enums.OperationTypes;

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
    public String makePayment(HttpServletRequest request, HttpServletResponse response) {
        String result = "";

        final String operationId = request.getParameter("operationId");

        if (isSupportPayment(operationId)) {
            LOGGER.info("There is Operation Replenishment Main Account Balance started");
            final User user = (User) request.getSession().getAttribute("loginedUser");
            final float amount = Float.valueOf(request.getParameter("amount"));

            updateUserAccBalance(user, amount);
            addToOperationHistory(user, amount);
            result = "Operation Successful";
        } else {
            try {
                LOGGER.info("There is not Replenishment Main Account Payment, try next");
                result = this.next.makePayment(request, response);
            } catch (NullPointerException e){
                LOGGER.debug("Not supporting payment operation from OpReplMainAccCommand.class in makePayment() method");
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

    private void updateUserAccBalance(User user, float amount) {
        UserAccDAO userAccDAO = factoryDAO.createUserAccDAO();
        UserAccount userAccount = userAccDAO.getById(user.getUserId());
        LOGGER.info("Try to update Main User Account Balance");
        final float newBalance = userAccount.getBalance() + amount;
        userAccDAO.updateBalanceById(user.getUserId(), newBalance);
        LOGGER.info("Main User Account Balance updated");
        }

    private void addToOperationHistory(User user,float amount) {
        OpReplenishment opReplenishment = new OpReplenishment();
        opReplenishment.setUserId(user.getUserId());
        opReplenishment.setAccName("MainAcc");
        opReplenishment.setAmount(amount);

        OpReplenishmentDAO opReplenishmentDAO = factoryDAO.createOpReplenishmentDAO();
        opReplenishmentDAO.create(opReplenishment);
        LOGGER.info("Operation Replenishment Main Account added to operation history");
    }
}
