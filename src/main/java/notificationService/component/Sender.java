package notificationService.component;

import java.util.List;

public interface Sender <T>{

    void send (T message);
    void send (List<T> message);
}
