package notificationService.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public abstract class Message {
    private String id;
    private ChannelKind channelKind;
    private String text;
    private Date creationDate;
    private Date sendDate;

    public Message() {
        id = UUID.randomUUID().toString();
        creationDate = new Date();
    }
    public Message(ChannelKind channelKind, String text, Date sendDate) {
        this();
        this.channelKind = channelKind;
        this.text = text;
        this.sendDate = sendDate;
    }
}
