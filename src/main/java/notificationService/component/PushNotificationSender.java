package notificationService.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PushNotificationSender<T> implements Senders<T> {
    private static final Logger LOGGER = LogManager.getLogger(PushNotificationSender.class);

    @Override
    public void sendMessage(T message) {
        LOGGER.debug("Send message: {} by push notification sender", message);
    }

    @Override
    public void sendMessage(List<T> messages) {
        LOGGER.debug("Send message: {} by push notification sender", messages);
    }
}
