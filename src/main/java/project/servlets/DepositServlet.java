package project.servlets;

import org.apache.log4j.Logger;
import project.model.DepositAccount;
import project.model.UserAccount;
import project.service.DepositService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class DepositServlet extends HttpServlet {

    private final Logger LOGGER = Logger.getLogger(DepositServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("DepositServlet call doGet() method");

        DepositService depositService = new DepositService();
        String command = "/views/open_deposit.jsp";

        UserAccount userAccount = (UserAccount) request.getSession().getAttribute("userAccount");

        if (userAccount.getDeposit()) {
            LOGGER.info("Deposit Account exist, get it from DB");
            int userId = (Integer) request.getSession().getAttribute("userId");
            DepositAccount depositAccount = depositService.getDepositAccountFromDB(userId);
            request.setAttribute("depositAccount", depositAccount);
            command = "/views/deposit.jsp";
        } else {
            LOGGER.info("Deposit account not exist, go to Open Deposit page");
        }
        request.getRequestDispatcher(command).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("DepositServlet call doPost() method");

        DepositService depositService = new DepositService();

        LOGGER.info("Try to create new Deposit account");
        DepositAccount depositAccount = new DepositAccount();
        int userId = (Integer) request.getSession().getAttribute("userId");
        depositAccount.setUserId(userId);
        depositAccount.setBalance(0.0f);
        depositAccount.setCurrency(request.getParameter("currency"));
        depositAccount.setRate(Float.valueOf(request.getParameter("rate")));
        depositAccount.setTerm(new Date(2019, 10, 05));
        depositService.createDepositAccountInDatabase(depositAccount);
        depositService.updateUserAccDepositStatus(userId);

        LOGGER.info("Creating new Deposit account successful");
        request.setAttribute("depositAccount", depositAccount);

        request.getRequestDispatcher("/signIn").forward(request, response);
    }
}
