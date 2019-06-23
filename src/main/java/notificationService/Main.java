package notificationService;

import notificationService.component.Converter;
import notificationService.component.EmailSender;
import notificationService.model.EmailMessage;

import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
//      NotificationService notificator = NotificationService.getInstance();

 //       EmailMessage emailMessage1 = new EmailMessage("Orlov", Arrays.asList("Petrov", "Ivanov"), "Hello", new Date());
//        EmailMessage emailMessage2 = new EmailMessage("Petrov", Arrays.asList("Orlov", "Ivanov"), "See you", new Date());
//
//        List<Message> messages = new ArrayList<>();
//        messages.add(emailMessage1);
//        messages.add(emailMessage2);
//
//        notificator.performMarketingCampaignMailing(messages);
//
//        PushNotification pushNotification = new PushNotification("1", "Hello", new Date());
//        messages.add(pushNotification);
//
//        notificator.performMarketingCampaignMailing(messages);
        EmailMessage emailMessage = new EmailMessage("Orlov", Arrays.asList("jjv","fvfv"), "fffg", new Date());
        EmailSender emailSender = new EmailSender();
        emailSender.sendMessage(emailMessage);
    }
}
