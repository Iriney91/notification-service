package notificationService.component;

import notificationService.component.Sender;

import java.util.List;

public class EmailSender <T> implements Sender <T> {
    @Override
    public void send(T message) {

    }

    @Override
    public void send(List <T> message) {

    }
}
