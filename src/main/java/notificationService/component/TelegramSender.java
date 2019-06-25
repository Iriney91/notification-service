package notificationService.component;

import notificationService.model.ChannelKind;
import notificationService.model.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class TelegramSender<T extends Message> implements  Sender<Message> {

    private static final Logger LOGGER = LogManager.getLogger(TelegramSender.class);
    public static String telegrampath = PropertiesService.getFilePath("src/main/resources/telegramSender.properties");

    @Override
    public void sendMessage(Message message) {
        Converter.convertToJson(Collections.singletonList(message), telegrampath);
        LOGGER.debug("Send message: {} by telegram sender", message);
    }

    @Override
    public void sendMessage(List<Message> messages) {
        Converter.convertToJson(messages, telegrampath);
        LOGGER.debug("Send message: {} by telegram sender", messages);
    }

    @Override
    public ChannelKind getChannelKind() {
        return ChannelKind.TELEGRAM;
    }

    @Override
    public void readMessage(String id, ChannelKind channelKind) {

    }

    @Override
    public void readMessages(ChannelKind channelKind) {

    }
}
