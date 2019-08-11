package project.DAO.queries;

import project.DAO.queries.DBFields.OpTransferFields;

public enum OpTransferSQL {

    INSERT_TO_OP_TRANSFER_TABLE("INSERT INTO `" + OpTransferFields.OP_TRANSFER  +
            "`(`" + OpTransferFields.SENDER_ID + "`, `" + OpTransferFields.RECIPIENT__MAIL + "`, " +
            "`" + OpTransferFields.AMOUNT + "`) VALUES ((?),(?),(?))"),

    GET_ALL_BY_ID("SELECT * FROM `" + OpTransferFields.OP_TRANSFER + "` " +
            "WHERE `" + OpTransferFields.SENDER_ID + "` =(?)"),

    DELETE(""),
    UPDATE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    OpTransferSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
