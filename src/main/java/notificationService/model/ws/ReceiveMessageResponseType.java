package notificationService.model.ws;

import lombok.Data;
import notificationService.model.Telegram;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ReceiveMessageResponseType")
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ReceiveMessageResponseType {

    private Telegram telegram;
}
