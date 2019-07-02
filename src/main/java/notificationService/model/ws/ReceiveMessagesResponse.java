package notificationService.model.ws;


import lombok.Data;
import notificationService.model.Telegram;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "ReceiveMessagesRequest")
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ReceiveMessagesResponse {

    private List <Telegram> telegram;
}
