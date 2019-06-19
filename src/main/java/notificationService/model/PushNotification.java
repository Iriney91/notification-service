package notificationService.model;

import lombok.Data;

import java.util.Date;
import java.util.Objects;
@Data

public class PushNotification extends  Message{
    private String recipientId;

    public PushNotification(String recipientId, String text, Date sendDate) {
        super(ChannelKind.PUSH, text, sendDate);
        this.recipientId = recipientId;
    }
}
