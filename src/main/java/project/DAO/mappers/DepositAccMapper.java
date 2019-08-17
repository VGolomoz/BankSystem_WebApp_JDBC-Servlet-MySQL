package project.DAO.mappers;

import project.DAO.queries.DBFields.DepositAccFields;
import project.model.DepositAccount;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepositAccMapper implements Mapper<DepositAccount> {


    @Override
    public DepositAccount getEntity(ResultSet resultSet) throws SQLException {

        DepositAccount depositAccount = new DepositAccount();

        depositAccount.setUserId(resultSet.getInt(DepositAccFields.USER_ID));
        depositAccount.setBalance(resultSet.getFloat(DepositAccFields.BALANCE));
        depositAccount.setCurrency(resultSet.getString(DepositAccFields.CURRENCY));
        depositAccount.setRate(resultSet.getFloat(DepositAccFields.RATE));
        depositAccount.setTerm(resultSet.getDate(DepositAccFields.TERM));

        return depositAccount;
    }
}
