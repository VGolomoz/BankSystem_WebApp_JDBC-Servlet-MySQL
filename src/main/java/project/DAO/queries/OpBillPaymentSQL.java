package project.DAO.queries;

import project.DAO.queries.DBFields.OpBillPaymentFields;

public enum OpBillPaymentSQL {

    INSERT_TO_OP_BILLPAYMENT_TABLE("INSERT INTO `" + OpBillPaymentFields.OP_BILL_PAY  +
            "`(`" + OpBillPaymentFields.USER_ID + "`, `" + OpBillPaymentFields.BILL_NUMBER + "`, " +
            "`" + OpBillPaymentFields.PURPOSE + "`,`" + OpBillPaymentFields.AMOUNT + "`," +
            "`" + OpBillPaymentFields.OPERATION_DATE + "` VALUES ((?),(?),(?),(?),(?))"),

    GET_ALL_BY_ID("SELECT * FROM `" + OpBillPaymentFields.OP_BILL_PAY + "` " +
            "WHERE `" + OpBillPaymentFields.USER_ID + "` =(?)"),

    DELETE(""),
    UPDATE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    OpBillPaymentSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
