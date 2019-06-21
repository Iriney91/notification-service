package notificationService.component;

import notificationService.model.Message;

abstract public class MessageWriter {
    public String path;

    abstract public void Write(Message message);
}
