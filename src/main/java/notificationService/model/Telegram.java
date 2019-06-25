package notificationService.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonAutoDetect
public class Telegram extends Message {

    private String telegramTo;
    private List<String> telegramCC;

    public Telegram() {
        super();
    }

    public Telegram(String telegramTo, List<String> telegramCC, String text, Date sendDate) {
        super(ChannelKind.TELEGRAM, text, sendDate);
        this.telegramTo = telegramTo;
        this.telegramCC = telegramCC;
    }
}
