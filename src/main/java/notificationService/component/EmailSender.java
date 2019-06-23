package notificationService.component;

import notificationService.model.ChannelKind;
import notificationService.model.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class EmailSender<T> implements Sender<T> {

    public static String path = PropertiesService.getFilePath("src/main/resources/emailSender.properties");

    private static final Logger LOGGER = LogManager.getLogger(EmailSender.class);

    @Override
    public void sendMessage(T message) {
        LOGGER.debug("Send message: {} by email sender", message);
    }

    @Override
    public void sendMessage(List<T> messages) {
        Converter.convertToCSV(messages);
        LOGGER.debug("Send message: {} by email sender", messages);
    }

    @Override
    public ChannelKind getChannelKind() {
        return ChannelKind.EMAIL;
    }
}
