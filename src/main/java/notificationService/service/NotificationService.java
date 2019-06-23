package notificationService.service;

import lombok.NonNull;
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

public class NotificationService {
    private static NotificationService instance;
    private Map<ChannelKind, Sender> senderMap = new HashMap<>();
    private static final Logger LOGGER = LogManager.getLogger(NotificationService.class);

    private NotificationService() {}

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    private void checkSenderPresence(List<ChannelKind> channelKinds) {

        if (senderMap.isEmpty()) {
            List<Sender> list = SenderFactory.create(channelKinds);
            list.stream().forEach(a -> senderMap.put(a.getChannelKind(), a));
            LOGGER.info(String.format("senderMap is filled : %d senders", senderMap.size()));
        } else {
            for (ChannelKind channelKind : channelKinds) {
                if (!senderMap.containsKey(channelKind)) {
                    senderMap.put(channelKind, SenderFactory.create(channelKind));
                    LOGGER.info(String.format("senderMap changed : %d senders", senderMap.size()));
                }
            }
        }
    }
    private void checkSenderPresence(@NonNull ChannelKind channelKind){
        if (!senderMap.containsKey(channelKind))
        senderMap.put(channelKind, SenderFactory.create(channelKind));
    }

    public void sendMessages(List<Message> messages) {
        if (messages == null || messages.size() < 1) {
            throw new IllegalArgumentException("Messages is empty");
        }
        checkSenderPresence(messages.stream()
                .filter(message -> (message.getChannelKind() != null))
                .map(Message::getChannelKind)
                .distinct()
                .collect(Collectors.toList()));
        LOGGER.info("created channelKinds");
        messages.stream()
                .collect(Collectors.groupingBy(Message::getChannelKind, Collectors.toList()))
                .forEach((channelKind, list) -> senderMap.get(channelKind).sendMessage(list));

    }

    public void sendMessage(Message message) {
        checkSenderPresence(message.getChannelKind());
        senderMap.get(message.getChannelKind()).sendMessage(message);
    }
}
