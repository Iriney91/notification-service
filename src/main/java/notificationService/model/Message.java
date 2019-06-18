package notificationService.model;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
                Objects.equals(creationDate, message.creationDate) &&
                Objects.equals(sendDate, message.sendDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, channelKind, text, creationDate, sendDate);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", channelKind=" + channelKind +
                ", text='" + text + '\'' +
                ", creationDate=" + creationDate +
                ", sendDate=" + sendDate +
                '}';
    }
}
