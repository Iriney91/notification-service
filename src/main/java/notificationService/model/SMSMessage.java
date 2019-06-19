package notificationService.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SMSMessage extends Message {

    private String smsTo;
    private List<String> smsCC;

    public SMSMessage(String emailTo, List<String> emailCC, String text, Date sendDate) {
        super(ChannelKind.SMS, text, sendDate);
        this.smsTo = emailTo;
        this.smsCC = emailCC;
    }
}
