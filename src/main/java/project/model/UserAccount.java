package project.model;

import project.util.enums.CurrencyType;

import java.sql.Date;
import java.util.Objects;

public class UserAccount extends Account{

    private Date validity;
    private Boolean deposit;
    private Boolean credit;

    public UserAccount() {
        this.balance = 0.0f;
        this.currency = CurrencyType.UAH.getTitle();
        this.deposit = false;
        this.credit = false;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public Boolean getDeposit() {
        return deposit;
    }

    public void setDeposit(Boolean deposit) {
        this.deposit = deposit;
    }

    public Boolean getCredit() {
        return credit;
    }

    public void setCredit(Boolean credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccount)) return false;
        if (!super.equals(o)) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(validity, that.validity) &&
                deposit.equals(that.deposit) &&
                credit.equals(that.credit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), validity, deposit, credit);
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "validity=" + validity +
                ", deposit=" + deposit +
                ", credit=" + credit +
                ", userId=" + userId +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                '}';
    }
}
