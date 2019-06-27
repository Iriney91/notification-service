package notificationService.component;

import notificationService.model.ChannelKind;
import notificationService.model.EmailMessage;
import notificationService.model.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class EmailMessager<T extends EmailMessage> implements Messager<Message> {

    public static String emailpath = PropertiesService.getFilePath("C:\\Users\\User\\IdeaProjects\\notification-service\\src\\main\\resources\\emailSender.properties");

    private static final Logger LOGGER = LogManager.getLogger(EmailMessager.class);

    @Override
    public void sendMessage(Message message) {
        Converter.main(Collections.singletonList(message));
        LOGGER.debug("Send message: {} by email sender", message);
    }

    @Override
    public void sendMessage(List<Message> messages) {
        Converter.main(messages);
        LOGGER.debug("Send message: {} by email sender", messages);
    }

    @Override
    public ChannelKind getChannelKind() {
        return ChannelKind.EMAIL;
    }
}
