package project.servlets.command;

import org.apache.log4j.Logger;
import project.service.OperationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OperationCommand implements Command {

    private final Logger LOGGER = Logger.getLogger(OperationCommand.class);
    OperationService operationService;

    public OperationCommand(OperationService operationService) {
        this.operationService = operationService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        request.setAttribute("opResult", operationService.makePayment(request, response));

        return "views/operations.jsp";
    }
}
