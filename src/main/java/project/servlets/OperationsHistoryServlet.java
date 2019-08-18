package project.servlets;

import org.apache.log4j.Logger;
import project.service.OperationService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OperationsHistoryServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(OperationsHistoryServlet.class);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("OperationsHistoryServlet call doGet() method");
        OperationService operationService = new OperationService();
        int userId = (Integer) request.getSession().getAttribute("userId");
        request.setAttribute("ReplMainAccHistory", operationService.getOpReplenishmentMainnAccHistory(userId));
        request.setAttribute("TransferHistory", operationService.getOpTransferHistory(userId));
        request.setAttribute("BillPaymentHistory", operationService.getOpBillPaymentHistory(userId));
        request.getRequestDispatcher("/views/operationsHistory.jsp").forward(request, response);
    }

}
