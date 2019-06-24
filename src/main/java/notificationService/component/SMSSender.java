package notificationService.component;

import notificationService.model.ChannelKind;
import notificationService.model.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class SMSSender <T extends Message> implements Sender<Message> {
    private static final Logger LOGGER = LogManager.getLogger(SMSSender.class);
    public static String smspath = PropertiesService.getFilePath("src\\main\\resources\\smsSender.properties");

    @Override
    public void sendMessage(Message message) {
        Converter.Serialize(Collections.singletonList(message), smspath);
        LOGGER.debug("Send message: {} by sms sender", message);
    }

    @Override
    public void sendMessage(List<Message> messages) {
        Converter.Serialize(messages, smspath);
        LOGGER.debug("Send message: {} by sms sender", messages);
    }

    @Override
    public ChannelKind getChannelKind() {
        return ChannelKind.SMS;
    }
}
