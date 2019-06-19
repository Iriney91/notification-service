package notificationService.service;

import notificationService.component.Sender;
import notificationService.component.SenderFactory;
import notificationService.model.ChannelKind;
import notificationService.model.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Notificator {
    private static Notificator instance;
    private Map<ChannelKind, Sender> senderMap = new HashMap<>();
    private static final Logger LOGGER = LogManager.getLogger(Notificator.class);

    private Notificator() {
    }

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
        List<ChannelKind> channelKinds = messages.stream()
                .filter(message -> {
                    if (message.getChannelKind() != null) return true;
                    else {
                        LOGGER.error("message.ChannelKind is null");
                        return false;
                    }
                })
                .map(Message::getChannelKind)
                .distinct()
                .collect(Collectors.toList());
        LOGGER.info("created channelKinds");


        if (senderMap.isEmpty()) {
            List<Sender> list = SenderFactory.create(channelKinds);
            list.stream().forEach(a -> senderMap.put(a.getChannelKind(), a));
            LOGGER.info(String.format("senderMap is feeled : %d senders", senderMap.size()));
        } else {
            for (ChannelKind channelKind : channelKinds) {
                if (!senderMap.containsKey(channelKind))
                    senderMap.put(channelKind, SenderFactory.create(channelKind));
                LOGGER.info(String.format("senderMap changed : %d senders", senderMap.size()));
            }
        }

        messages.forEach(message -> sendMessage(message));

    }

    public void sendMessage(Message message) {
        if (!senderMap.containsKey(message.getChannelKind()))
            throw new IllegalStateException("No such sender");

        else senderMap.get(message.getChannelKind()).sendMessage(message);
    }
}

//    List<MessageSender> list = SenderFactory.create(channels);
//list.stream().forEach(a-> senders.put(a.getChannelKind(),a));


//    List<Sender> list = SenderFactory.create(channelKinds);
//list.stream().forEach(a-> senders.put(a.getChannelKind(),a));

// SenderFactory.create(channelKinds).stream().map(sender -> senderMap.put(sender.getChannelKind(), sender));