package notificationService.service;

import notificationService.component.Senders;
import notificationService.component.SenderFactory;
import notificationService.model.ChannelKind;
import notificationService.model.Message;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Notificator {
    private static Notificator instance;
    private Map <ChannelKind, Senders> senderMap;

    void performMarketingCampaingMailing (List <Message> messages){

        senderMap=messages.stream()
                .collect(Collectors.toMap(
                        Message::getChannelKind
                        ,message -> SenderFactory.create(message.getChannelKind())
                ));
    }

    private Notificator() {
    }
    public static Notificator getInstance(){
        if (instance==null)return new Notificator();
        return instance;
    }
}

