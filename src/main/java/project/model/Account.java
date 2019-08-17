package project.model;

import java.util.Objects;

public abstract class Account {

    protected int userId;
    protected float balance;
    protected String currency;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return userId == account.userId &&
                Float.compare(account.balance, balance) == 0 &&
                currency.equals(account.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, balance, currency);
    }
}
