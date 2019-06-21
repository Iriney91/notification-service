package notificationService.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data

public class Telegram extends Message {

    private String telegramTo;
    private List<String> telegramCC;

    public Telegram(String telegramTo, List<String> telegramCC, String text, Date sendDate) {
        super(ChannelKind.TELEGRAM, text, sendDate);
        this.telegramTo = telegramTo;
        this.telegramCC = telegramCC;
    }
}
