package notificationService.model.ws;


import lombok.Data;
import notificationService.model.Message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "ReceiveMessagesResponseType")
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ReceiveMessagesResponseType {

    private List <Message> telegram;
}
