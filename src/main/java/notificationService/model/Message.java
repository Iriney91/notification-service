package notificationService.model;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public abstract class Message {
    private String id;
    private ChannelKind channelKind;
    private String text;
    private Date creationData;
    private Date sendDate;


    public Message() {
        id = UUID.randomUUID().toString();
        creationData = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ChannelKind getChannelKind() {
        return channelKind;
    }

    public void setChannelKind(ChannelKind channelKind) {
        this.channelKind = channelKind;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreationData() {
        return creationData;
    }

    public void setCreationData(Date creationData) {
        this.creationData = creationData;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) &&
                channelKind == message.channelKind &&
                Objects.equals(text, message.text) &&
                Objects.equals(creationData, message.creationData) &&
                Objects.equals(sendDate, message.sendDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, channelKind, text, creationData, sendDate);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", channelKind=" + channelKind +
                ", text='" + text + '\'' +
                ", creationData=" + creationData +
                ", sendDate=" + sendDate +
                '}';
    }
}
