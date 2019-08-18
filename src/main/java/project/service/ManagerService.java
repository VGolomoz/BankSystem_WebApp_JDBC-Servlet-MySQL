package project.service;

import org.apache.log4j.Logger;
import project.DAO.interfaces.FactoryDAO;

public class ManagerService {

    private FactoryDAO factoryDAO = FactoryDAO.getInstance();
    private static final Logger LOG = Logger.getLogger(UserService.class);


}
