package project.service;

import org.apache.log4j.Logger;
import project.DAO.interfaces.FactoryDAO;
import project.DAO.interfaces.OpBillPaymentDAO;
import project.DAO.interfaces.OpReplenishmentDAO;
import project.DAO.interfaces.OpTransferDAO;
import project.model.OpBillPayment;
import project.model.OpReplenishment;
import project.model.OpTransfer;
import project.service.paymentCommand.OpBillPaymentCommand;
import project.service.paymentCommand.OpReplMainAccCommand;
import project.service.paymentCommand.OpTransferCommand;
import project.util.myExceptions.UnsupportedPaymentException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class OperationService {

    private final Logger LOGGER = Logger.getLogger(OperationService.class);
    private FactoryDAO factoryDAO = FactoryDAO.getInstance();

    public String makePayment(HttpServletRequest request, HttpServletResponse response) {

        String result = null;

        OpReplMainAccCommand opReplMainAccCommand = new OpReplMainAccCommand();
        OpBillPaymentCommand opBillPaymentCommand = new OpBillPaymentCommand();
        opReplMainAccCommand.setNext(opBillPaymentCommand);
        opBillPaymentCommand.setNext(new OpTransferCommand());


        try {
            result = opReplMainAccCommand.makePayment(request, response);
        } catch (UnsupportedPaymentException e) {
            LOGGER.debug("Not supporting payment operation", e);
        }
     return result;
    }

    public List<OpReplenishment> getOpReplenishmentMainnAccHistory(int id){
        LOGGER.info("get all operations replenushment main acc history from DB");
            OpReplenishmentDAO opReplenishmentDAO = factoryDAO.createOpReplenishmentDAO();
            return opReplenishmentDAO.getAllById(id);
    }

    public List<OpTransfer> getOpTransferHistory(int id){
        LOGGER.info("get all operations transfer history from DB");
        OpTransferDAO opTransferDAO = factoryDAO.createOpTransferDAO();
        return opTransferDAO.getAllById(id);
    }

    public List<OpBillPayment> getOpBillPaymentHistory(int id){
        LOGGER.info("get all operations bill payment main acc history from DB");
        OpBillPaymentDAO opBillPaymentDAO = factoryDAO.createOpBillPaymentDAO();
        return opBillPaymentDAO.getAllById(id);
    }

}
