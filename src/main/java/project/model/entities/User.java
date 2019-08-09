package project.model.entities;

import java.util.Objects;

public class User {

    private int userId;
    private String mail;
    private String pass;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return userId == user.userId &&
                mail.equals(user.mail) &&
                pass.equals(user.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, mail, pass);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", mail='" + mail + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
