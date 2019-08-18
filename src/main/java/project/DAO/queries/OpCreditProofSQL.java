package project.DAO.queries;

import project.DAO.queries.DBFields.OpCreditProofFields;

public enum OpCreditProofSQL {

    READ_BY_ID("SELECT * FROM `" + OpCreditProofFields.OP_CREDIT_PROOF + "` " +
            "WHERE `" + OpCreditProofFields.USER_ID + "` =(?)"),

    INSERT_TO_OP_CREDITPROOF_TABLE("INSERT INTO `" + OpCreditProofFields.OP_CREDIT_PROOF  + "' " +
            "`(`" + OpCreditProofFields.USER_ID + "`, `" + OpCreditProofFields.MANAGER_ID + "`, " +
            "`" + OpCreditProofFields.DATE + "`,`" + OpCreditProofFields.DECISION + "` " +
            "VALUES ((?),(?),(?),(?))"),

    INSERT_ID_REQUEST_TO_CREDITPROOF_TABLE("INSERT INTO `" + OpCreditProofFields.OP_CREDIT_PROOF + "` " +
            "SET `" + OpCreditProofFields.USER_ID + "` =(?)"),

    GET_ALL_BY_ID("SELECT * FROM `" + OpCreditProofFields.OP_CREDIT_PROOF + "` " +
            "WHERE `" + OpCreditProofFields.USER_ID + "` =(?)"),

    DELETE(""),
    UPDATE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    OpCreditProofSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
