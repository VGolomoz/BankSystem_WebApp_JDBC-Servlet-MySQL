package project.model;

import java.util.Objects;

public class OpReplenishment extends Operation{

    private float amount;
    private String accName;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OpReplenishment)) return false;
        if (!super.equals(o)) return false;
        OpReplenishment that = (OpReplenishment) o;
        return Float.compare(that.amount, amount) == 0 &&
                accName.equals(that.accName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), amount, accName);
    }

    @Override
    public String toString() {
        return "OpReplenishment{" +
                "amount=" + amount +
                ", accName='" + accName + '\'' +
                ", userId=" + userId +
                ", operationDate=" + operationDate +
                '}';
    }
}
