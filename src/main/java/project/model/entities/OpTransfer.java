package project.model.entities;

import java.util.Objects;

public class OpTransfer extends Operation {

    private int recipientId;
    private float amount;

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
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
        return recipientId == that.recipientId &&
                Float.compare(that.amount, amount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recipientId, amount);
    }

    @Override
    public String toString() {
        return "OpTransfer{" +
                "recipientId=" + recipientId +
                ", amount=" + amount +
                ", userId=" + userId +
                ", operationDate=" + operationDate +
                '}';
    }
}
