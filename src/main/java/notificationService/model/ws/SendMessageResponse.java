package notificationService.model.ws;

import lombok.Data;
import notificationService.model.Telegram;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
@XmlType(name = "CreateMessageResponseType")
public class SendMessageResponse {

        private Telegram telegram;
}
