package project.service;

import org.apache.log4j.Logger;
import project.DAO.interfaces.FactoryDAO;
import project.DAO.interfaces.OpCreditProofDAO;
import project.model.OpCreditProof;


public class CreditProofService  {

    private FactoryDAO factoryDAO = FactoryDAO.getInstance();
    private static final Logger LOG = Logger.getLogger(CreditProofService.class);

    public void makeCreditIdRequset(int id) {
        LOG.info("make Credit request in DB");
        OpCreditProofDAO opCreditProofDAO = factoryDAO.createOpCreditProofDAO();
        opCreditProofDAO.createIdRequest(id);
    }

    public OpCreditProof getCreditRequestFromDB (int id){
        LOG.info("get Credit Request from DB");
        OpCreditProofDAO opCreditProofDAO = factoryDAO.createOpCreditProofDAO();
        OpCreditProof opCreditProof = opCreditProofDAO.getById(id);
        return opCreditProof;
    }

}
