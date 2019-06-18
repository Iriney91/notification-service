package notificationService.component;

import notificationService.model.ChannelKind;

import java.util.ArrayList;
import java.util.List;

public class SenderFactory {

    public static Sender create(ChannelKind channelKind) {
        switch (channelKind) {
            case SMS:
                return new SMSSender();
            case EMAIL:
                return new EmailSender();
            case PUSH:
                return new PushNotificationSender();
            default:
                throw new IllegalArgumentException("Unknown channelKind");
        }
    }

    public static List<Sender> create(List<ChannelKind> kinds) {
        List<Sender> sender = new ArrayList();
        for (ChannelKind type : kinds) {
            sender.add(create(type));
        }
        return sender;
    }
}
