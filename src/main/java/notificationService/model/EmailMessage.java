package notificationService.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class EmailMessage extends Message {

    private String emailTo;
    private List<String> emailCC;

    public EmailMessage(String emailTo, List<String> emailCC, String text, Date sendDate) {
        super(ChannelKind.EMAIL, text, sendDate);
        this.emailTo = emailTo;
        this.emailCC = emailCC;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public List<String> getEmailCC() {
        return emailCC;
    }

    public void setEmailCC(List<String> emailCC) {
        this.emailCC = emailCC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EmailMessage that = (EmailMessage) o;
        return Objects.equals(emailTo, that.emailTo) &&
                Objects.equals(emailCC, that.emailCC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), emailTo, emailCC);
    }

    @Override
    public String toString() {
        return "EmailMessage{" +
                "emailTo='" + emailTo + '\'' +
                ", emailCC=" + emailCC +
                '}';
    }
}
