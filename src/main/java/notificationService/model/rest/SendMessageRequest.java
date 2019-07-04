package notificationService.model.rest;

import lombok.Data;

import java.util.Date;
@Data
public class SendMessageRequest {

    private String text;
    private Date sendDate;
    private String phone;
}
