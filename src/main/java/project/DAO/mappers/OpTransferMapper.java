package project.DAO.mappers;

import project.DAO.queries.DBFields.OpTransferFields;
import project.model.entities.OpTransfer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OpTransferMapper implements Mapper<OpTransfer> {


    @Override
    public OpTransfer getEntity(ResultSet resultSet) throws SQLException {

        OpTransfer opTransfer = new OpTransfer();

        opTransfer.setUserId(resultSet.getInt(OpTransferFields.SENDER_ID));
        opTransfer.setRecipientId(resultSet.getInt(OpTransferFields.RECIPIENT_ID));
        opTransfer.setAmount(resultSet.getFloat(OpTransferFields.AMOUNT));
        opTransfer.setOperationDate(resultSet.getDate(OpTransferFields.OPERATION_DATE));

        return opTransfer;
    }
}
