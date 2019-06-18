package notificationService.model;

import java.util.Date;

public abstract class Message {
    ChannelKind channelKind;
    String text;
    Date createData;
    Date sendDate;
}
