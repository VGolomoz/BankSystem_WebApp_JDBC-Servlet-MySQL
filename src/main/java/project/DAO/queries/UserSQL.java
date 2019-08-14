package project.DAO.queries;

import project.DAO.queries.DBFields.UsersFields;

public enum UserSQL {
    READ_BY_ID("SELECT * FROM `" + UsersFields.USERS + "` " +
            "WHERE `" + UsersFields.USER_ID + "` =(?)"),

    READ_ALL("SELECT * FROM `" + UsersFields.USERS + "` "),

    INSERT_TO_USERS_TABLE("INSERT INTO `" + UsersFields.USERS + "` " +
            "(`" + UsersFields.MAIL + "`, `" + UsersFields.PASS + "`, `" + UsersFields.ROLE + "`) VALUES ((?),(?),(?))"),

    READ_BY_MAIL("SELECT * FROM `" + UsersFields.USERS + "` " +
            "WHERE `" + UsersFields.MAIL + "` =(?)"),

    READ_ID_BY_MAIL("SELECT `" +UsersFields.USER_ID+ "` FROM `" + UsersFields.USERS + "` " +
            "WHERE `" + UsersFields.MAIL + "` =(?)"),

    READ_BY_MAIL_AND_PASS("SELECT * FROM `" + UsersFields.USERS + "` " +
            "WHERE `" + UsersFields.MAIL + "` =(?)" +
            "AND `" + UsersFields.PASS + "` =(?)"),

    DELETE(""),
    UPDATE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    UserSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}

