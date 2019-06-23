package notificationService.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class SMSMessage extends Message implements Serializable {

    private String smsTo;
    private List<String> smsCC;

    public SMSMessage(String smsTo, List<String> smsCC, String text, Date sendDate) {
        super(ChannelKind.SMS, text, sendDate);
        this.smsTo = smsTo;
        this.smsCC = smsCC;
    }
}
