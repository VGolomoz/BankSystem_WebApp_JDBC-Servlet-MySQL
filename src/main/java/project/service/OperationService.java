package project.service;

import project.service.paymentCommand.OpBillPaymentCommand;
import project.service.paymentCommand.OpReplMainAccCommand;
import project.service.paymentCommand.OpTransferCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OperationService {

    public String makePayment(HttpServletRequest request, HttpServletResponse response) {

        OpReplMainAccCommand opReplMainAccCommand = new OpReplMainAccCommand();
        OpBillPaymentCommand opBillPaymentCommand = new OpBillPaymentCommand();
        opReplMainAccCommand.setNext(opBillPaymentCommand);
        opBillPaymentCommand.setNext(new OpTransferCommand());


         return opReplMainAccCommand.makePayment(request, response);

    }
}
