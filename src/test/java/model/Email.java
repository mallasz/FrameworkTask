package model;

public class Email {
    private String emailAddress;
    private String emailSubject;

    public Email(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getEmailSubject() {
        return emailSubject;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
