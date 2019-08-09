package project.model.entities;

import java.sql.Date;
import java.util.Objects;

public class DepositAccount extends Account {

    private float rate;
    private Date term;

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public Date getTerm() {
        return term;
    }

    public void setTerm(Date term) {
        this.term = term;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepositAccount)) return false;
        if (!super.equals(o)) return false;
        DepositAccount that = (DepositAccount) o;
        return Float.compare(that.rate, rate) == 0 &&
                term.equals(that.term);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rate, term);
    }

    @Override
    public String toString() {
        return "DepositAccount{" +
                "rate=" + rate +
                ", term=" + term +
                ", userId=" + userId +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                '}';
    }
}
