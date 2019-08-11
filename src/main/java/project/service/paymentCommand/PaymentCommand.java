package project.service.paymentCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PaymentCommand {

    void setNext(PaymentCommand next);

     String makePayment(HttpServletRequest request, HttpServletResponse response);

     boolean isSupportPayment(String operationId);
}
