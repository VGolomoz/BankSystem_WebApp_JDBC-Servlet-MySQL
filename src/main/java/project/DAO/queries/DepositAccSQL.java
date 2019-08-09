package project.DAO.queries;

import project.DAO.queries.DBFields.DepositAccFields;

public enum DepositAccSQL {

    INSERT_TO_DEPOSIT_ACCOUNT_TABLE("INSERT INTO `" + DepositAccFields.DEP_ACC  +
            "`(`" + DepositAccFields.USER_ID + "`, `" + DepositAccFields.BALANCE + "`, `" + DepositAccFields.CURRENCY + "`, " +
            "`" + DepositAccFields.RATE + "`, `" + DepositAccFields.TERM + "`) VALUES ((?),(?),(?),(?),(?))"),

    READ_BY_ID("SELECT * FROM `" + DepositAccFields.DEP_ACC + "` " +
            "WHERE `" + DepositAccFields.USER_ID + "` =(?)"),


    DELETE(""),
    UPDATE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    DepositAccSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
