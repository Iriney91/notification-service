package notificationService.component;

import notificationService.model.ChannelKind;
import notificationService.model.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public interface Messager<T extends Message> {

    Logger LOGGER = LogManager.getLogger(Messager.class);

    default void sendMessage(T message) {
        LOGGER.debug("Send message: {} by default sender", message);
    }

    default void sendMessage(List<T> messages) {
        LOGGER.debug("Send messages: {} by default sender", messages);
    }

    default Message receiveMessage(String id, ChannelKind channelKind) {
        LOGGER.debug("Read message: {} by default sender");
        return null;
    }

    default List<Message> receiveMessages(ChannelKind channelKind) {
        LOGGER.debug("Read messages: {} by default sender");
        return null;
    }

    ChannelKind getChannelKind();
}
