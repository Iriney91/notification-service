package notificationService.model.dto;

import notificationService.model.Telegram;
import notificationService.model.dto.rest.TelegramDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TelegramMapper {

    TelegramMapper MAPPER = Mappers.getMapper(TelegramMapper.class);
    TelegramDTO  domainToDto (Telegram telegram);
    Telegram dtoToDomain (TelegramDTO telegramDTO);
}
