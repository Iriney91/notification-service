package notificationService.component;

import notificationService.model.ChannelKind;

import java.util.ArrayList;
import java.util.List;

public class SenderFactory {

    public static Senders create (ChannelKind channelKind){
        switch (channelKind){
            case SMS:
                return new SMSSender();
            case EMAIL:
                return new EmailSender();
                default:
                    return null;
        }
    }
    public static List <Senders> create (List <ChannelKind> kinds){

        List<Senders> sender = new ArrayList();
        for (ChannelKind type : kinds) {
            sender.add(create(type));
        }
        return sender;
    }
}
