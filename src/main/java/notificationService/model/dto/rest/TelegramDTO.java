package notificationService.model.dto.rest;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TelegramDTO {

    private  String text;
    private String phone;
}
