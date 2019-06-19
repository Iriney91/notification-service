package notificationService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;
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
