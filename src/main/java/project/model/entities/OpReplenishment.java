package project.model.entities;

import java.util.Objects;

public class OpReplenishment extends Operation{

    private float amount;
    private String acc_name;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getAcc_name() {
        return acc_name;
    }

    public void setAcc_name(String acc_name) {
        this.acc_name = acc_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OpReplenishment)) return false;
        if (!super.equals(o)) return false;
        OpReplenishment that = (OpReplenishment) o;
        return Float.compare(that.amount, amount) == 0 &&
                acc_name.equals(that.acc_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), amount, acc_name);
    }

    @Override
    public String toString() {
        return "OpReplenishment{" +
                "amount=" + amount +
                ", acc_name='" + acc_name + '\'' +
                ", userId=" + userId +
                ", operationDate=" + operationDate +
                '}';
    }
}
