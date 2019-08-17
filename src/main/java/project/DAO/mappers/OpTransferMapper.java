package project.DAO.mappers;

import project.DAO.queries.DBFields.OpTransferFields;
import project.model.OpTransfer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OpTransferMapper implements Mapper<OpTransfer> {


    @Override
    public OpTransfer getEntity(ResultSet resultSet) throws SQLException {

        OpTransfer opTransfer = new OpTransfer();

        opTransfer.setUserId(resultSet.getInt(OpTransferFields.SENDER_ID));
        opTransfer.setRecipientMail(resultSet.getString(OpTransferFields.RECIPIENT__MAIL));
        opTransfer.setAmount(resultSet.getFloat(OpTransferFields.AMOUNT));
        opTransfer.setOperationDate(resultSet.getDate(OpTransferFields.OPERATION_DATE));

        return opTransfer;
    }
}
