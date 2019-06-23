package notificationService;

import notificationService.model.*;
import notificationService.service.NotificationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationService notificator = NotificationService.getInstance();

//        EmailMessage emailMessage1 = new EmailMessage("Orlov", Arrays.asList("Petrov", "Ivanov"), "Hello", new Date());
//        EmailMessage emailMessage2 = new EmailMessage("Petrov", Arrays.asList("Orlov", "Ivanov"), "See you", new Date());
//
//        List<Message> messages = new ArrayList<>();
//        messages.add(emailMessage1);
//        messages.add(emailMessage2);
//        notificator.sendMessages(messages);
//
//        EmailMessage emailMessage = new EmailMessage("Orlov", Arrays.asList("Petrov", "Pupkin"), "Hello", new Date());
//        notificator.sendMessage(emailMessage);
//        PushNotification pushNotification = new PushNotification("1", "Hello", new Date());
//        PushNotification pushNotification2 = new PushNotification("1", "Hello", new Date());
//        List <Message> messages= new ArrayList<>();
//        messages.add(pushNotification);
//        messages.add(pushNotification2);
//        notificator.sendMessages(messages);

        Telegram telegram = new Telegram("Orlov", Arrays.asList("Petrov", "Pupkin"), "Hello", new Date());
        Telegram telegram2 = new Telegram("Orlov", Arrays.asList("Petrov", "Pupkin"), "Hello", new Date());
        List <Message> messages = new ArrayList<>();
        messages.add(telegram);
        messages.add(telegram2);
        notificator.sendMessages(messages);

        SMSMessage smsMessage = new SMSMessage("Orlov", Arrays.asList("pupkin", "Petrov"), "Hello", new Date());
        notificator.sendMessage(smsMessage);

    }
}
