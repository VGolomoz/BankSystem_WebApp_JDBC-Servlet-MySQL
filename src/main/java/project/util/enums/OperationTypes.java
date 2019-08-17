package project.util.enums;

public enum OperationTypes {

    BILL_PAYMENT ("OpBillPayment"),
    TRANSFER ("OpTransfer"),
    REPL_MAIN_ACC ("OpReplenishmentMainAcc"),
    REPL_DEPOSIT ("OpReplenishmentDeposit"),
    REPL_CREDIT ("OpReplenishmentCredit");

    String title;

    OperationTypes(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
