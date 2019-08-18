package project.servlets;

import org.apache.log4j.Logger;
import project.model.CreditAccount;
import project.model.OpCreditProof;
import project.model.UserAccount;
import project.service.CreditProofService;
import project.service.CreditService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreditServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(CreditServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("CreditServlet call doGet() method");

        String command = "/views/open_credit.jsp";

        UserAccount userAccount = (UserAccount) request.getSession().getAttribute("userAccount");
        int userId = (Integer) request.getSession().getAttribute("userId");


        if (userAccount.getCredit()) {
            LOGGER.info("Credit Account exist, get it from DB");
            CreditService creditService = new CreditService();
            CreditAccount creditAccount = creditService.getCreditAccountFromDB(userId);
            request.setAttribute("creditAccount", creditAccount);
            command = "/views/credit.jsp";
        } else {
            LOGGER.info("Credit account not exist, check credit request");
            CreditProofService creditProofService = new CreditProofService();
            OpCreditProof opCreditProof = creditProofService.getCreditRequestFromDB(userId);
            if (opCreditProof.getUserId() != 0 && opCreditProof.getDecision() != null) {
                LOGGER.info("Decision: " + opCreditProof.getDecision());
                LOGGER.info("Credit account request has denied status");
                request.setAttribute("request denied", "Denied");
            }
            else if (opCreditProof.getUserId() != 0) {
                LOGGER.info("Credit account request has pending status");
                request.setAttribute("request pending", "Pending");
            }
        }
        request.getRequestDispatcher(command).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("CreditServlet call doPost() method");

        CreditService creditService = new CreditService();
        CreditProofService creditProofService = new CreditProofService();

        LOGGER.info("Create new Credit account and make request");
        CreditAccount creditAccount = new CreditAccount();
        int userId = (Integer) request.getSession().getAttribute("userId");
        creditAccount.setUserId(userId);
        creditAccount.setBalance(0.0f);
        creditAccount.setCurrency(request.getParameter("currency"));
        creditAccount.setLimit(Float.valueOf(request.getParameter("limit")));
        creditAccount.setRate(Float.valueOf(request.getParameter("rate")));
        creditAccount.setAccrued_interest(0.0f);
        creditService.createCreditAccountInDatabase(creditAccount);

        creditProofService.makeCreditIdRequset(userId);

        LOGGER.info("Creating new Credit account and request successful");
        request.setAttribute("creditAccount", creditAccount);

        request.getRequestDispatcher("/signIn").forward(request, response);;
    }
}
