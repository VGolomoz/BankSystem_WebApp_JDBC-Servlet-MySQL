package project.DAO.mappers;

import project.DAO.queries.DBFields.OpCreditProofFields;
import project.model.entities.OpCreditProof;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OpCreditProofMapper implements Mapper<OpCreditProof> {


    @Override
    public OpCreditProof getEntity(ResultSet resultSet) throws SQLException {

        OpCreditProof opCreditProof = new OpCreditProof();
        opCreditProof.setUserId(resultSet.getInt(OpCreditProofFields.USER_ID));
        opCreditProof.setManagerId(resultSet.getInt(OpCreditProofFields.MANAGER_ID));
        opCreditProof.setOperationDate(resultSet.getDate(OpCreditProofFields.DATE));
        opCreditProof.setDecision(resultSet.getBoolean(OpCreditProofFields.DECISION));

        return opCreditProof;
    }
}
