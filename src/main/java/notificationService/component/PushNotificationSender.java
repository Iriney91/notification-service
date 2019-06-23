package notificationService.component;

import notificationService.model.ChannelKind;
import notificationService.model.Message;
import notificationService.model.PushNotification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class PushNotificationSender<T extends PushNotification> implements Sender<Message> {
    private static final Logger LOGGER = LogManager.getLogger(PushNotificationSender.class);
    public static String pushpath = PropertiesService.getFilePath("src/main/resources/pushnotificationSender.properties");

    @Override
    public void sendMessage(Message message) {
        Converter.convertToXML(Collections.singletonList(message), pushpath);
        LOGGER.debug("Send message: {} by push notification sender", message);
    }

    @Override
    public void sendMessage(List<Message> messages) {
        Converter.convertToXML(messages, pushpath);
        LOGGER.debug("Send message: {} by push notification sender", messages);
    }

    @Override
    public ChannelKind getChannelKind() {
        return ChannelKind.PUSH;
    }
}
