package project.model.entities;

import java.util.Objects;

public class OpBillPayment extends Operation {

    private String billNumber;
    private String purpose;
    private float amount;

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OpBillPayment)) return false;
        if (!super.equals(o)) return false;
        OpBillPayment that = (OpBillPayment) o;
        return Float.compare(that.amount, amount) == 0 &&
                billNumber.equals(that.billNumber) &&
                purpose.equals(that.purpose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), billNumber, purpose, amount);
    }

    @Override
    public String toString() {
        return "OpBillPayment{" +
                "billNumber='" + billNumber + '\'' +
                ", purpose='" + purpose + '\'' +
                ", amount=" + amount +
                ", userId=" + userId +
                ", operationDate=" + operationDate +
                '}';
    }
}
