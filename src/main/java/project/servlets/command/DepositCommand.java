package project.servlets.command;

import org.apache.log4j.Logger;
import project.model.entities.DepositAccount;
import project.model.entities.User;
import project.model.entities.UserAccount;
import project.service.DepositService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DepositCommand implements Command {

    private final Logger LOG = Logger.getLogger(DepositCommand.class);
    private DepositService depositService;
    DepositAccount depositAccount;

    public DepositCommand(DepositService depositService) {
        this.depositService = depositService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String command = "/views/open_deposit.jsp";
        User user;
        UserAccount userAccount = (UserAccount) request.getSession().getAttribute("userAccount");

        if (userAccount.getDeposit()) {
            LOG.info("Deposit Account exist, get it from DB");
            user = (User) request.getSession().getAttribute("loginedUser");
            depositAccount = depositService.getDepositAccountFromDB(user);
            request.setAttribute("depositAccount", depositAccount);
            System.out.println(depositAccount.toString());
            command = "/views/deposit.jsp";
        } else {
            LOG.info("Deposit account not exist, go to Open Deposit page");
        }
        return command;
    }
}
