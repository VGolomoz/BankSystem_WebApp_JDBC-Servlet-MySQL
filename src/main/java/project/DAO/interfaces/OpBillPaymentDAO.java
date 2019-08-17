package project.DAO.interfaces;

import project.model.OpBillPayment;

import java.util.List;

public interface OpBillPaymentDAO extends DAO<OpBillPayment> {

    public List<OpBillPayment> getAllById(int id);

}
