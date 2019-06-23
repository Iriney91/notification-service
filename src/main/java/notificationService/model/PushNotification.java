package notificationService.model;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.Date;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PushNotification extends Message{

    public String recipientId;

    public PushNotification() {
        super();
    }

    public PushNotification(String recipientId, String text, Date sendDate) {
        super(ChannelKind.PUSH, text, sendDate);
        this.recipientId = recipientId;
    }
}
