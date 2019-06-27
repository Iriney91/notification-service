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

        EmailMessage emailMessage1 = new EmailMessage("Orlov", Arrays.asList("Petrov", "Ivanov"), "Hello", new Date());
        EmailMessage emailMessage2 = new EmailMessage("Petrov", Arrays.asList("Orlov", "Ivanov"), "See you", new Date());
        EmailMessage emailMessage = new EmailMessage("Orlov", Arrays.asList("Petrov", "Pupkin"), "Hello", new Date());
        PushNotification pushNotification = new PushNotification("1", "Hello", new Date());
        PushNotification pushNotification2 = new PushNotification("1", "Hello", new Date());
        Telegram telegram = new Telegram( "Hello", new Date(), "83947555");
        Telegram telegram2 = new Telegram("Hello", new Date(), "89364653476");
        Telegram telegram1 = new Telegram("gd", new Date(), "4568570");
        SMSMessage smsMessage = new SMSMessage("Orlov", Arrays.asList("pupkin", "Petrov"), "Hello", new Date());
        List<Message> messages = new ArrayList<>();
        messages.add(emailMessage1);
        messages.add(emailMessage2);
        messages.add(emailMessage);
        messages.add(pushNotification);
        messages.add(pushNotification2);
        messages.add(telegram);
        messages.add(telegram2);
        messages.add(smsMessage);
        notificator.sendMessages(messages);







    }
}
