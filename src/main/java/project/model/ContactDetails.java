package project.model;

import java.sql.Date;
import java.util.Objects;

public class ContactDetails {

    private int userId;
    private String name;
    private String lastName;
    private String address;
    private String mobilePhone;
    private String mail;
    private Date birthday;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactDetails)) return false;
        ContactDetails that = (ContactDetails) o;
        return userId == that.userId &&
                name.equals(that.name) &&
                lastName.equals(that.lastName) &&
                Objects.equals(address, that.address) &&
                mobilePhone.equals(that.mobilePhone) &&
                mail.equals(that.mail) &&
                birthday.equals(that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, lastName, address, mobilePhone, mail, birthday);
    }

    @Override
    public String toString() {
        return "ContactDetails{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", mail='" + mail + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
