package project.model.enums;

public enum Role {
    ADMIN("ADMIN"),
    MANAGER("MANAGER"),
    CLIENT("CLIENT");

    String title;

    Role(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}