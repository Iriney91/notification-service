package notificationService.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.Date;

@Data
@JsonAutoDetect
public class Telegram extends Message {

    private String phone;

    public Telegram() {
        super();
        setChannelKind(ChannelKind.TELEGRAM);
    }

    public Telegram(String text, Date sendDate, String phone) {
        super(ChannelKind.TELEGRAM, text, sendDate);
        this.phone = phone;
    }
}
