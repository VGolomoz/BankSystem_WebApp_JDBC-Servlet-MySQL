package project.model.enums;

public enum CurrencyType {
    UAH("UAH"),
    USD("USD"),
    EUR("EUR");

    String title;

    CurrencyType(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
