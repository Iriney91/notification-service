package notificationService.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EmailMessage extends Message {

    private String emailTo;
    private List<String> emailCC;

    public EmailMessage(String emailTo, List<String> emailCC, String text, Date sendDate) {
        super(ChannelKind.EMAIL, text, sendDate);
        this.emailTo = emailTo;
        this.emailCC = emailCC;
    }
}
