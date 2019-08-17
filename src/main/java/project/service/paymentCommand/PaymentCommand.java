package project.service.paymentCommand;

import project.util.MyExceptions.UnsupportedPaymentException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PaymentCommand {

    void setNext(PaymentCommand next);

     String makePayment(HttpServletRequest request, HttpServletResponse response) throws UnsupportedPaymentException;

     boolean isSupportPayment(String operationId);
}
