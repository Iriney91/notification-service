package notificationService.model.ws;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlType(name = "CreateMessageRequestType")
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class SendMessageRequest {

        private String text;
        private Date sendDate;
        private String phone;
}
