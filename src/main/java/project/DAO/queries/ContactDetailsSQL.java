package project.DAO.queries;

import project.DAO.queries.DBFields.ContactDetailsFields;

public enum ContactDetailsSQL {

    INSERT_TO_CONTACT_DETAILS_TABLE("INSERT INTO `" + ContactDetailsFields.CONTACT_DETAILS +
            "`(`" + ContactDetailsFields.USER_ID + "`, `" + ContactDetailsFields.USER_NAME + "`, `" + ContactDetailsFields.USER_LASTNAME + "`, `" +
            ContactDetailsFields.ADDRESS + "`, `" + ContactDetailsFields.MAIL + "`, `" + ContactDetailsFields.MOB_PHONE + "`, " +
            "`" + ContactDetailsFields.BIRTHDAY + "`) VALUES ((?),(?),(?),(?),(?),(?),(?))"),

    READ_BY_ID("SELECT * FROM `" + ContactDetailsFields.CONTACT_DETAILS + "` " +
            "WHERE `" + ContactDetailsFields.USER_ID + "` =(?)"),

    DELETE(""),
    UPDATE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    ContactDetailsSQL(String QUERY) {
        this.QUERY = QUERY;
    }


}
