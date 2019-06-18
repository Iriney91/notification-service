package notificationService.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public interface Senders<T> {

    Logger LOGGER = LogManager.getLogger(Senders.class);

    default void sendMessage(T message) {
        LOGGER.debug("Send message: {} by default sender", message);
    }

    default void sendMessage(List<T> messages) {
        LOGGER.debug("Send messages: {} by default sender", messages);
    }

}
