package project.DAO.mappers;

import project.DAO.queries.DBFields.OpBillPaymentFields;
import project.model.OpBillPayment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OpBillPaymentMapper implements Mapper<OpBillPayment> {


    @Override
    public OpBillPayment getEntity(ResultSet resultSet) throws SQLException {

        OpBillPayment opBillPayment = new OpBillPayment();
        opBillPayment.setUserId(resultSet.getInt(OpBillPaymentFields.USER_ID));
        opBillPayment.setBillNumber(resultSet.getString(OpBillPaymentFields.BILL_NUMBER));
        opBillPayment.setPurpose(resultSet.getString(OpBillPaymentFields.PURPOSE));
        opBillPayment.setAmount(resultSet.getFloat(OpBillPaymentFields.AMOUNT));
        opBillPayment.setOperationDate(resultSet.getDate(OpBillPaymentFields.OPERATION_DATE));

        return opBillPayment;
    }
}
