package project.DAO.queries;

import project.DAO.queries.DBFields.CreditAccFields;

public enum CreditAccSQL {

    INSERT_TO_CREDIT_ACCOUNT_TABLE("INSERT INTO `" + CreditAccFields.CREDIT_ACC  +
            "`(`" + CreditAccFields.USER_ID + "`, `" + CreditAccFields.BALANCE + "`, `" + CreditAccFields.CURRENCY + "`, " +
            "`" + CreditAccFields.LIMIT + "`, `" + CreditAccFields.RATE + "`, `" + CreditAccFields.ACCRUED_INTEREST + "`) " +
            "VALUES ((?),(?),(?),(?),(?),(?))"),

    READ_BY_ID("SELECT * FROM `" + CreditAccFields.CREDIT_ACC + "` " +
            "WHERE `" + CreditAccFields.USER_ID + "` =(?)"),


    DELETE(""),
    UPDATE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    CreditAccSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
