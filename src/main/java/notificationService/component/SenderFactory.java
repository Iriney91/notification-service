package notificationService.component;

import notificationService.model.ChannelKind;

import java.util.ArrayList;
import java.util.List;

public class SenderFactory {

    public static Messager create(ChannelKind channelKind) {
        switch (channelKind) {
            case SMS:
                return new SMSMessager();
            case EMAIL:
                return new EmailMessager();
            case PUSH:
                return new PushNotificationMessager();
            case TELEGRAM:
                return  new TelegramMessager();
            default:
                throw new IllegalArgumentException("Unknown channelKind");
        }
    }

    public static List<Messager> create(List<ChannelKind> kinds) {
        List<Messager> messager = new ArrayList();
        for (ChannelKind type : kinds) {
            messager.add(create(type));
        }
        return messager;
    }
}
