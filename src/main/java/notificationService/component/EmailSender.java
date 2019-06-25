package notificationService.component;

import notificationService.model.ChannelKind;
import notificationService.model.EmailMessage;
import notificationService.model.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class EmailSender<T extends EmailMessage> implements Sender<Message> {

    public static String emailpath = PropertiesService.getFilePath("src/main/resources/emailSender.properties");

    private static final Logger LOGGER = LogManager.getLogger(EmailSender.class);

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
