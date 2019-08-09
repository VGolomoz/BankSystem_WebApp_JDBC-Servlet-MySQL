package project.DAO.queries;

import project.DAO.queries.DBFields.OpReplenishmentFields;

public enum OpReplenishmentSQL {

    INSERT_TO_OP_REPLENISHMENT_TABLE("INSERT INTO `" + OpReplenishmentFields.OP_REPLENISHMENT  +
            "`(`" + OpReplenishmentFields.USER_ID + "`, `" + OpReplenishmentFields.AMOUNT + "`, " +
            "`" + OpReplenishmentFields.ACC_NAME + "`,`" + OpReplenishmentFields.OPERATION_DATE + "`," +
            "VALUES ((?),(?),(?),(?))"),

    GET_ALL_BY_ID("SELECT * FROM `" + OpReplenishmentFields.OP_REPLENISHMENT + "` " +
            "WHERE `" + OpReplenishmentFields.USER_ID + "` =(?)"),

    DELETE(""),
    UPDATE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    OpReplenishmentSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
