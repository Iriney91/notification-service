package notificationService.component;

import notificationService.model.ChannelKind;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TelegramSender<T> implements  Sender<T> {

    private static final Logger LOGGER = LogManager.getLogger(TelegramSender.class);

    @Override
    public void sendMessage(T message) {
        LOGGER.debug("Send message: {} by telegram sender", message);
    }

    @Override
    public void sendMessage(List<T> messages) {
        LOGGER.debug("Send message: {} by telegram sender", messages);
    }

    @Override
    public ChannelKind getChannelKind() {
        return ChannelKind.TELEGRAM;
    }
}
