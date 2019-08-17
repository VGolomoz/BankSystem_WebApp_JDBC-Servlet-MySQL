package project.DAO.mappers;

import project.DAO.queries.DBFields.UsersFields;
import project.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserMapper implements Mapper<User> {
    @Override
    public User getEntity(ResultSet resultSet) throws SQLException {

        User user = new User();
        user.setUserId(resultSet.getInt(UsersFields.USER_ID));
        user.setMail(resultSet.getString(UsersFields.MAIL));
        user.setRoleId(resultSet.getInt(UsersFields.ROLE));

        return user;
    }
}
