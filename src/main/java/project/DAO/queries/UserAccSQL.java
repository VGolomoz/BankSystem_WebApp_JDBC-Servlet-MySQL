package project.DAO.queries;

import project.DAO.queries.DBFields.UserAccFields;

public enum UserAccSQL {

    INSERT_TO_USER_ACCOUNT_TABLE("INSERT INTO `" + UserAccFields.USER_ACC  +
            "`(`" + UserAccFields.USER_ID + "`, `" + UserAccFields.CURRENCY + "`, `" + UserAccFields.VALIDITY + "`, " +
            "`" + UserAccFields.BALANCE + "`, `" + UserAccFields.DEPOSIT + "`, `" + UserAccFields.CREDIT + "`) " +
            "VALUES ((?),(?),(?),(?),(?),(?))"),

    READ_BY_ID("SELECT * FROM `" + UserAccFields.USER_ACC + "` " +
                        "WHERE `" + UserAccFields.USER_ID + "` =(?)"),

    UPDATE_DEPOSIT_STATUS_BY_ID ( "UPDATE `" + UserAccFields.USER_ACC + "` " +
            "SET `" + UserAccFields.DEPOSIT + "` = (1)" +
            "WHERE `" + UserAccFields.USER_ID + "` =(?)"),

    UPDATE_CREDIT_STATUS_BY_ID ( "UPDATE `" + UserAccFields.USER_ACC + "` " +
            "SET `" + UserAccFields.CREDIT + "` = (1)" +
            "WHERE `" + UserAccFields.USER_ID + "` =(?)"),

    UPDATE_BALANCE_BY_ID ( "UPDATE `" + UserAccFields.USER_ACC + "` " +
            "SET `" + UserAccFields.BALANCE + "` = (?)" +
            "WHERE `" + UserAccFields.USER_ID + "` =(?)"),


    DELETE(""),
    UPDATE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    UserAccSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
