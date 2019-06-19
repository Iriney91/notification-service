package notificationService.component;

import notificationService.model.ChannelKind;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public interface Sender<T> {

    Logger LOGGER = LogManager.getLogger(Sender.class);

    default void sendMessage(T message) {
        LOGGER.debug("Send message: {} by default sender", message);
    }

    default void sendMessage(List<T> messages) {
        LOGGER.debug("Send messages: {} by default sender", messages);
    }

    ChannelKind getChannelKind();
}
