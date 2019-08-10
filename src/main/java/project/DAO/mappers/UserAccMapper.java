package project.DAO.mappers;

import project.DAO.queries.DBFields.UserAccFields;
import project.model.entities.UserAccount;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccMapper implements Mapper<UserAccount> {


    @Override
    public UserAccount getEntity(ResultSet resultSet) throws SQLException {

        UserAccount userAccount = new UserAccount();
        userAccount.setBalance(resultSet.getFloat(UserAccFields.BALANCE));
        userAccount.setCurrency(resultSet.getString(UserAccFields.CURRENCY));
        userAccount.setValidity(resultSet.getDate(UserAccFields.VALIDITY));
        userAccount.setDeposit(resultSet.getBoolean(UserAccFields.DEPOSIT));
        userAccount.setCredit(resultSet.getBoolean(UserAccFields.CREDIT));

        return userAccount;
    }
}