package project.DAO.mappers;

import project.DAO.queries.DBFields.CreditAccFields;
import project.model.entities.CreditAccount;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CreditAccMapper implements Mapper<CreditAccount> {


    @Override
    public CreditAccount getEntity(ResultSet resultSet) throws SQLException {

        CreditAccount creditAccount = new CreditAccount();
        creditAccount.setUserId(resultSet.getInt(CreditAccFields.USER_ID));
        creditAccount.setBalance(resultSet.getFloat(CreditAccFields.BALANCE));
        creditAccount.setCurrency(resultSet.getString(CreditAccFields.CURRENCY));
        creditAccount.setLimit(resultSet.getInt(CreditAccFields.LIMIT));
        creditAccount.setRate(resultSet.getInt(CreditAccFields.RATE));
        creditAccount.setAccrued_interest(resultSet.getInt(CreditAccFields.ACCRUED_INTEREST));

        return creditAccount;
    }
}
