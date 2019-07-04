package notificationService.web.web;


import notificationService.model.Telegram;
import notificationService.model.ws.*;
import notificationService.service.NotificationService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(
        serviceName = "TelegramWebService",
        targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service/telegram-service")
//@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)

public class TelegramWebService {
    NotificationService notificationService = NotificationService.getInstance();

    @WebMethod
    @WebResult(partName = "receiveMessagesResponse", targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service/telegram-service")
    public ReceiveMessagesResponseType receiveMessages(@WebParam(partName = "receiveMessagesChannelRequest",
            targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service") ReceiveMessagesRequestType request) {

        ReceiveMessagesResponseType response = new ReceiveMessagesResponseType();
        response.setTelegram(notificationService.receiveMessages(request.getChannelKind()));
        return response;
    }

    @WebMethod
    @WebResult(
            partName = "receiveMessageResponse",
            targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service/telegram-service")
    public ReceiveMessageResponseType receiveMessage(@WebParam(
            partName = "receiveMessageRequest",
            targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service/telegram-service")
                                                             ReceiveMessageRequestType request) {

        ReceiveMessageResponseType response = new ReceiveMessageResponseType();
        response.setTelegram((Telegram) notificationService.receiveMessage(request.getId(), request.getChannelKind()));
        return response;
    }

    @WebMethod
    @WebResult(partName = "sendMessageResponse", targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service/telegram-service")
    public SendMessageResponseType sendMessage(@WebParam(
            partName = "sendMessageRequest",
            targetNamespace = "http://www.itfbgroup.ru/telecom/notification-service/telegram-service")
                                                       SendMessageRequestType request) {

        Telegram message = new Telegram(request.getText(), request.getSendDate(), request.getPhone());

        SendMessageResponseType response = new SendMessageResponseType();
        response.setTelegram((Telegram) notificationService.sendMessage(message));
        return response;
    }
}
