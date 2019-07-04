package notificationService.component;

import notificationService.model.ChannelKind;
import notificationService.model.Message;
import notificationService.util.CommonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SMSMessager<T extends Message> implements Messager<Message> {
    private static final Logger LOGGER = LogManager.getLogger(SMSMessager.class);
    public static Path propertyFilePath = Paths.get(CommonUtil.readProperty("smsSender.properties").getProperty("message.path"));

    @Override
    public void sendMessage(Message message) {
        Converter.Serialize(Collections.singletonList(message), propertyFilePath);
        LOGGER.debug("Send message: {} by sms sender", message);
    }

    @Override
    public void sendMessage(List<Message> messages) {
        Converter.Serialize(messages, propertyFilePath);
        LOGGER.debug("Send message: {} by sms sender", messages);
    }

    @Override
    public ChannelKind getChannelKind() {
        return ChannelKind.SMS;
    }
}
