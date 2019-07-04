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

public class TelegramMessager<T extends Message> implements Messager<Message> {

    private static final Logger LOGGER = LogManager.getLogger(TelegramMessager.class);
    public static Path propertyFilePath = Paths.get(CommonUtil.readProperty("telegramSender.properties").getProperty("message.path"));

    @Override
    public void sendMessage(Message message) {
        Converter.convertToJson(Collections.singletonList(message), propertyFilePath);
        LOGGER.debug("Send message: {} by telegram sender", message);
    }

    @Override
    public void sendMessage(List<Message> messages) {
        Converter.convertToJson(messages, propertyFilePath);
        LOGGER.debug("Send message: {} by telegram sender", messages);
    }

    @Override
    public ChannelKind getChannelKind() {
        return ChannelKind.TELEGRAM;
    }

    @Override
    public Message receiveMessage(String id, ChannelKind channelKind) {
        return Converter.convertFromJson(channelKind, propertyFilePath, id);
    }

    @Override
    public List <Message> receiveMessages(ChannelKind channelKind) {
        return  Converter.convertFromJson(channelKind, propertyFilePath);
    }
}
