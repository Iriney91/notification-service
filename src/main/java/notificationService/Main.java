package notificationService;

import notificationService.model.EmailMessage;
import notificationService.model.Message;
import notificationService.model.PushNotification;
import notificationService.service.Notificator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Notificator notificator = Notificator.getInstance();

        EmailMessage emailMessage1 = new EmailMessage("Orlov", Arrays.asList("Petrov", "Ivanov"), "Hello", new Date());
        EmailMessage emailMessage2 = new EmailMessage("Petrov", Arrays.asList("Orlov", "Ivanov"), "See you", new Date());

        List<Message> messages = new ArrayList<>();
        messages.add(emailMessage1);
        messages.add(emailMessage2);

        notificator.performMarketingCampaignMailing(messages);

        PushNotification pushNotification = new PushNotification("1", "Hello", new Date());
        messages.add(pushNotification);

        notificator.performMarketingCampaignMailing(messages);
    }
}
