package notificationService.web.rest;

import notificationService.model.rest.TelegramDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = TelegramMapper.class)
public interface TelegramMapper {

    @Mappings({
            @Mapping(source = "phone", target ="phone")
    })
    TelegramDTO  dto (TelegramDTO dto);
    TelegramMapper INSTANSE = Mappers.getMapper(TelegramMapper.class);
}
