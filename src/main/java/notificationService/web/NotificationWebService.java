package notificationService.web;


import notificationService.model.ChannelKind;
import notificationService.model.Message;
import notificationService.model.PushNotification;
import notificationService.service.NotificationService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.List;

@WebService(serviceName = "NotificationWebService", portName = "NotificationWebPort", targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)

public class NotificationWebService {
    NotificationService notificationService = NotificationService.getInstance();

    @WebMethod
    @WebResult(partName = "receiveMessagesResponse", targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service")
    public List<Message> receiveMessages(@WebParam(partName = "receiveMessagesChannelRequest",
            targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service") ChannelKind channelKind) {
        return notificationService.receiveMessages(channelKind);
    }


    @WebMethod
    @WebResult(partName = "receiveMessagesResponse", targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service")
    public Message receiveMessage(@WebParam(
            name = "id",
            partName = "receiveMessageIdRequest",
            targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service") String id,
                                  @WebParam(
                                          name = "channel",
                                          partName = "receiveMessageChannelRequest",
                                          targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service") ChannelKind channelKind) {

        return notificationService.receiveMessage(id, channelKind);
    }

    @WebMethod
    public PushNotification sendMessage(PushNotification message) {
        PushNotification push = new PushNotification("1", "Hello", new Date());
        notificationService.sendMessage(push);
        return push;
    }
}
