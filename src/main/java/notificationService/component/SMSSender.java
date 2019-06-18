package notificationService.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SMSSender <T> implements Sender<T> {
    private static final Logger LOGGER = LogManager.getLogger(SMSSender.class);

    @Override
    public void sendMessage(T message) {
        LOGGER.debug("Send message: {} by sms sender", message);
    }

    @Override
    public void sendMessage(List<T> messages) {
        LOGGER.debug("Send message: {} by sms sender", messages);
    }
}
