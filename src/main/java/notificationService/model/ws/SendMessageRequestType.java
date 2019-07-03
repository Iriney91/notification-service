package notificationService.model.ws;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlType(name = "SendMessageRequestType")
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class SendMessageRequestType {

        private String text;
        private Date sendDate;
        private String phone;
}
