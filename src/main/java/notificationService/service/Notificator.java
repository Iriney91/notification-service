package notificationService.service;

import notificationService.component.Sender;
import notificationService.component.SenderFactory;
import notificationService.model.ChannelKind;
import notificationService.model.Message;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Notificator {
    private static Notificator instance;
    private Map<ChannelKind, Sender> senderMap;

    private Notificator() {}

    public static Notificator getInstance() {
        if (instance == null) {
            instance = new Notificator();
        }
        return instance;
    }

    public void performMarketingCampaignMailing(List<Message> messages) {
        if (messages == null || messages.size() < 1) {
            throw new IllegalArgumentException("Messages is empty");
        }

        senderMap = messages.stream()
                .filter(message -> message.getChannelKind() != null)
                .map(Message::getChannelKind)
                .distinct()
                .collect(Collectors.toMap(kind -> kind, SenderFactory::create));

        senderMap.forEach(
                (key, value) -> value.sendMessage(
                        messages.stream()
                                .filter(msg -> msg.getChannelKind() == key)
                                .collect(Collectors.toList())
                )
        );
    }
}

