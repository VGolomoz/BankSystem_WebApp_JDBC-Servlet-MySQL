package project.model.entities;


import java.util.Objects;

public class CreditAccount extends Account{

    private float limit;
    private float rate;
    private float accrued_interest;

    public float getLimit() {
        return limit;
    }

    public void setLimit(float limit) {
        this.limit = limit;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getAccrued_interest() {
        return accrued_interest;
    }

    public void setAccrued_interest(float accrued_interest) {
        this.accrued_interest = accrued_interest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditAccount)) return false;
        if (!super.equals(o)) return false;
        CreditAccount that = (CreditAccount) o;
        return Float.compare(that.limit, limit) == 0 &&
                Float.compare(that.rate, rate) == 0 &&
                Float.compare(that.accrued_interest, accrued_interest) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), limit, rate, accrued_interest);
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "limit=" + limit +
                ", rate=" + rate +
                ", accrued_interest=" + accrued_interest +
                ", userId=" + userId +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                '}';
    }
}
