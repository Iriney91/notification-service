package notificationService.component;

import notificationService.model.ChannelKind;
import notificationService.model.EmailMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;
import java.util.Properties;

public class EmailSender<T> implements Sender<T> {

    private String messagepath;
    private PrintWriter writer;

    public EmailSender() {
        Properties properties = new Properties();
        FileInputStream fis;

        try {
            fis = new FileInputStream("src/main/resources/emailSender.properties");
            properties.load(fis);
            fis.close();
            messagepath = properties.getProperty("message.path");
        } catch (IOException e) {
            LOGGER.error("Файл свойств отсуствует!");
        }
    }

    private static final Logger LOGGER = LogManager.getLogger(EmailSender.class);

    @Override
    public void sendMessage(T message) {
        LOGGER.debug("Send message: {} by email sender", message);
    }

    @Override
    public void sendMessage(List<T> messages) {
        LOGGER.debug("Send message: {} by email sender", messages);
    }

    @Override
    public ChannelKind getChannelKind() {
        return ChannelKind.EMAIL;
    }
}
