package notificationService.web;


import notificationService.model.ChannelKind;
import notificationService.model.Message;
import notificationService.model.PushNotification;
import notificationService.model.Telegram;
import notificationService.model.ws.ReceiveMessageRequest;
import notificationService.model.ws.ReceiveMessageResponse;
import notificationService.model.ws.SendMessageRequest;
import notificationService.model.ws.SendMessageResponse;
import notificationService.service.NotificationService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.List;

@WebService(serviceName = "TelegramService", portName = "NotificationWebPort", targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)

public class TelegramService {
    NotificationService notificationService = NotificationService.getInstance();

    @WebMethod
    @WebResult(partName = "receiveMessagesResponse", targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service")
    public List<Message> receiveMessages(@WebParam(partName = "receiveMessagesChannelRequest",
            targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service") ChannelKind channelKind) {
        return notificationService.receiveMessages(channelKind);
    }


    @WebMethod
    @WebResult(partName = "receiveMessagesResponse", targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service")
    public ReceiveMessageResponse receiveMessage(@WebParam(
            name = "id",
            partName = "receiveMessageIdRequest",
            targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service")ReceiveMessageRequest request){

        ReceiveMessageResponse response = new ReceiveMessageResponse();
        response.setTelegram((Telegram)notificationService.receiveMessage(request.getId(),request.getChannelKind()));
        return response;
    }

//    @WebMethod
//    @WebResult(partName = "receiveMessagesResponse", targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service")
//    public Message receiveMessage(@WebParam(
//            name = "id",
//            partName = "receiveMessageIdRequest",
//            targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service") String id,
//                                  @WebParam(
//                                          name = "channel",
//                                          partName = "receiveMessageChannelRequest",
//                                          targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service") ChannelKind channelKind) {
//
//        return notificationService.receiveMessage(id, channelKind);
//    }

    @WebMethod
    @WebResult(partName = "sendMessageResponse", targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service/telegram-service")
    public SendMessageResponse sendMessage(@WebParam(
            name = "sendMessageRequest",
            partName = "sendMessageRequest",
            targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service/telegram-service")
                                                   SendMessageRequest request) {

        Telegram message = new Telegram(request.getText(), request.getSendDate(), request.getPhone());

        SendMessageResponse response = new SendMessageResponse();
        response.setTelegram((Telegram) notificationService.sendMessage(message));
        return response;
    }
}
