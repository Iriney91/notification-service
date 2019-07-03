package notificationService.model.ws;

import lombok.Data;
import notificationService.model.ChannelKind;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ReceiveMessageRequestType")
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ReceiveMessageRequestType {

    private String id;
    private ChannelKind channelKind;
}
