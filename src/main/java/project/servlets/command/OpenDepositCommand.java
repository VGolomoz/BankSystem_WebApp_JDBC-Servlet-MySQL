package project.servlets.command;

import org.apache.log4j.Logger;
import project.model.entities.DepositAccount;
import project.model.entities.User;
import project.service.DepositService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class OpenDepositCommand implements Command {

    private final Logger LOG = Logger.getLogger(OpenDepositCommand.class);
    private DepositService depositService;

    public OpenDepositCommand(DepositService depositService) {
        this.depositService = depositService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.info("Try to create new Deposit account");
        DepositAccount depositAccount = new DepositAccount();
        User user = (User)request.getSession().getAttribute("loginedUser");
        depositAccount.setUserId(user.getUserId());
        depositAccount.setBalance(0.0f);
        depositAccount.setCurrency(request.getParameter("currency"));
        depositAccount.setRate(Float.valueOf(request.getParameter("rate")));
        depositAccount.setTerm(new Date(2019, 10, 05));
        depositService.createDepositAccountInDatabase(depositAccount);
        depositService.updateUserAccDepositStatus(user);

        LOG.info("Creating new Deposit account successful");
        request.setAttribute("depositAccount", depositAccount);

        return "/views/deposit.jsp";
    }
}
