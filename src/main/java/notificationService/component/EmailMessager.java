package notificationService.component;

import notificationService.model.ChannelKind;
import notificationService.model.EmailMessage;
import notificationService.model.Message;
import notificationService.util.CommonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class EmailMessager<T extends EmailMessage> implements Messager<Message> {

    public static Path propertyFilePath = Paths.get(CommonUtil.readProperty("emailSender.properties").getProperty("message.path"));

    private static final Logger LOGGER = LogManager.getLogger(EmailMessager.class);

    @Override
    public void sendMessage(Message message) {
        Converter.convertToCSV(Collections.singletonList(message));
        LOGGER.debug("Send message: {} by email sender", message);
    }

    @Override
    public void sendMessage(List<Message> messages) {
        Converter.convertToCSV(messages);
        LOGGER.debug("Send message: {} by email sender", messages);
    }

    @Override
    public ChannelKind getChannelKind() {
        return ChannelKind.EMAIL;
    }
}
