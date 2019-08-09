package project.DAO.mappers;

import project.DAO.queries.DBFields.OpReplenishmentFields;
import project.model.entities.OpReplenishment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OpReplenishmentMapper implements Mapper<OpReplenishment> {


    @Override
    public OpReplenishment getEntity(ResultSet resultSet) throws SQLException {

        OpReplenishment opReplenishment = new OpReplenishment();

        opReplenishment.setUserId(resultSet.getInt(OpReplenishmentFields.USER_ID));
        opReplenishment.setAmount(resultSet.getFloat(OpReplenishmentFields.AMOUNT));
        opReplenishment.setAcc_name(resultSet.getString(OpReplenishmentFields.ACC_NAME));
        opReplenishment.setOperationDate(resultSet.getDate(OpReplenishmentFields.OPERATION_DATE));

        return opReplenishment;
    }
}
