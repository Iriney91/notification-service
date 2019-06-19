package notificationService.component;

import notificationService.model.ChannelKind;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PushNotificationSender<T> implements Sender<T> {
    private static final Logger LOGGER = LogManager.getLogger(PushNotificationSender.class);

//    @Override
//    public void sendMessage(T message) {
//        LOGGER.debug("Send message: {} by push notification sender", message);
//    }

//    @Override
//    public void sendMessage(List<T> messages) {
//        LOGGER.debug("Send message: {} by push notification sender", messages);
//    }

    @Override
    public ChannelKind getChannelKind() {
        return ChannelKind.PUSH;
    }
}
