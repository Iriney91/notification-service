package notificationService.model;

import java.util.Date;

public abstract class Message {
    ChannelKind channelKind;
    String text;
    Date createData;
    Date sendDate;

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

    public Date getCreateData() {
        return createData;
    }

    public void setCreateData(Date createData) {
        this.createData = createData;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
}
