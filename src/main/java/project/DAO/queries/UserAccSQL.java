package project.DAO.queries;

import project.DAO.queries.DBFields.UserAccFields;

public enum UserAccSQL {

    INSERT_TO_USER_ACCOUNT_TABLE("INSERT INTO `" + UserAccFields.USER_ACC  +
            "`(`" + UserAccFields.USER_ID + "`, `" + UserAccFields.CURRENCY + "`, `" + UserAccFields.VALIDITY + "`, " +
            "`" + UserAccFields.BALANCE + "`, `" + UserAccFields.DEPOSIT + "`, `" + UserAccFields.CREDIT + "`) " +
            "VALUES ((?),(?),(?),(?),(?),(?))"),

    READ_BY_ID("SELECT * FROM `" + UserAccFields.USER_ACC + "` " +
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
