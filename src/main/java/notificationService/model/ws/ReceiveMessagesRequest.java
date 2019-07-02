package notificationService.model.ws;

import lombok.Data;
import notificationService.model.ChannelKind;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ReceiveMessagesRequest")
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ReceiveMessagesRequest {

    private ChannelKind channelKind;
}
