package project.servlets.command;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrUserCommand implements Command {

    private final Logger LOGGER = Logger.getLogger(RegistrUserCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Open Registration page");
        return "views/registration.jsp";
    }
}
