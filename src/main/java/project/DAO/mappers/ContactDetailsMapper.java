package project.DAO.mappers;

import project.DAO.queries.DBFields.ContactDetailsFields;
import project.model.entities.ContactDetails;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactDetailsMapper implements Mapper<ContactDetails> {


    @Override
    public ContactDetails getEntity(ResultSet resultSet) throws SQLException {
        ContactDetails contactDetails = new ContactDetails();

        contactDetails.setName(resultSet.getString(ContactDetailsFields.USER_NAME));
        contactDetails.setLastName(resultSet.getString(ContactDetailsFields.USER_LASTNAME));
        contactDetails.setAddress(resultSet.getString(ContactDetailsFields.ADDRESS));
        contactDetails.setMobile_phone(resultSet.getString(ContactDetailsFields.MOB_PHONE));
        contactDetails.setBirthday(resultSet.getDate(ContactDetailsFields.BIRTHDAY));

        return contactDetails;
    }
}
