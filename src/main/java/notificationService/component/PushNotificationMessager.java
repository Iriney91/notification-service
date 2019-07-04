package notificationService.component;

import notificationService.model.ChannelKind;
import notificationService.model.Message;
import notificationService.model.PushNotification;
import notificationService.util.CommonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class PushNotificationMessager<T extends PushNotification> implements Messager<Message> {
    private static final Logger LOGGER = LogManager.getLogger(PushNotificationMessager.class);
    public static Path propertyFilePath = Paths.get(CommonUtil.readProperty("pushnotificationSender.properties").getProperty("message.path"));

    @Override
    public void sendMessage(Message message) {
        Converter.convertToXML(Collections.singletonList(message), propertyFilePath);
        LOGGER.debug("Send message: {} by push notification sender", message);
    }

    @Override
    public void sendMessage(List<Message> messages) {
        Converter.convertToXML(messages, propertyFilePath);
        LOGGER.debug("Send message: {} by push notification sender", messages);
    }

    @Override
    public ChannelKind getChannelKind() {
        return ChannelKind.PUSH;
    }
}
