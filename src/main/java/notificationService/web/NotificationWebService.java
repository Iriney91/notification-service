package notificationService.web;


import notificationService.model.ChannelKind;
import notificationService.model.Message;
import notificationService.model.PushNotification;
import notificationService.service.NotificationService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.List;

@WebService(name = "NotificationWebService", targetNamespace = "http://www.itfbgroup.ru/notificationWebService")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)

public class NotificationWebService {
    NotificationService notificationService = NotificationService.getInstance();
    @WebMethod
    public List<Message> receiveMessages(ChannelKind channelKind) {
        return notificationService.receiveMessages(ChannelKind.TELEGRAM);
    }
    @WebMethod
    public Message receiveMessage(String id, ChannelKind channelKind) {
        return notificationService.receiveMessage("78668d0c-557d-4902-b55e-742212656715", ChannelKind.TELEGRAM);
    }
    @WebMethod
    public PushNotification sendMessage(PushNotification message) {
        PushNotification push = new PushNotification("1", "Hello", new Date());
        notificationService.sendMessage(push);
        return push;
    }
}
