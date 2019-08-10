package project.model.entities;

import project.model.enums.Role;

import java.util.Objects;

public class User {

    private int userId;
    private String mail;
    private String pass;
    private String role;

    public User() {
        this.role = Role.CLIENT.getTitle();
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return userId == user.userId &&
                mail.equals(user.mail) &&
                pass.equals(user.pass) &&
                role.equals(user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, mail, pass, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", mail='" + mail + '\'' +
                ", pass='" + pass + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
