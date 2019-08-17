package project.service;

import org.apache.log4j.Logger;
import project.service.paymentCommand.OpBillPaymentCommand;
import project.service.paymentCommand.OpReplMainAccCommand;
import project.service.paymentCommand.OpTransferCommand;
import project.util.MyExceptions.UnsupportedPaymentException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OperationService {

    private final Logger LOGGER = Logger.getLogger(OperationService.class);

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
}
