package project.model;

import java.util.Objects;

public class OpTransfer extends Operation {

    private String recipientMail;
    private float amount;

    public String getRecipientMail() {
        return recipientMail;
    }

    public void setRecipientMail(String recipientMail) {
        this.recipientMail = recipientMail;
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
        if (!(o instanceof OpTransfer)) return false;
        if (!super.equals(o)) return false;
        OpTransfer that = (OpTransfer) o;
        return Float.compare(that.amount, amount) == 0 &&
                recipientMail.equals(that.recipientMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recipientMail, amount);
    }

    @Override
    public String toString() {
        return "OpTransfer{" +
                "recipientMail='" + recipientMail + '\'' +
                ", amount=" + amount +
                ", userId=" + userId +
                ", operationDate=" + operationDate +
                '}';
    }
}
