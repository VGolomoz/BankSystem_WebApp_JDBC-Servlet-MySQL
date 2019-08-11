package project.service;

import project.service.paymentCommand.OpBillPaymentCommand;
import project.service.paymentCommand.OpTransferCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OperationService {

    public String makePayment(HttpServletRequest request, HttpServletResponse response) {


        OpBillPaymentCommand opBillPaymentCommand = new OpBillPaymentCommand();
        OpTransferCommand opTransferCommand = new OpTransferCommand();
        opBillPaymentCommand.setNext(opTransferCommand);

         return opBillPaymentCommand.makePayment(request, response);

    }
}
