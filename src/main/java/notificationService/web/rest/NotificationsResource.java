package notificationService.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import notificationService.model.ChannelKind;
import notificationService.model.Telegram;
import notificationService.model.dto.TelegramMapper;
import notificationService.model.dto.rest.TelegramDTO;
import notificationService.service.NotificationService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;


@Api(value = "notification-service")
@Path("/notifications")
public class NotificationsResource {
    NotificationService notificationService = NotificationService.getInstance();

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }

    @GET
    @Path("/get/{ChannelKind}")
    @ApiOperation(value = "sendMessagesAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotification(@PathParam("ChannelKind") ChannelKind channelKind) {
        return Response.ok()
                .entity(
                        notificationService.receiveMessages(channelKind).stream()
                                .map(m -> TelegramMapper.MAPPER.domainToDto((Telegram) m))
                                .collect(Collectors.toList())
                )
                .build();
    }

    @GET
    @Path("/get/{ChannelKind}/{id}")
    @ApiOperation(value = "SendMessage")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotification(@PathParam("ChannelKind") ChannelKind channelKind, @PathParam("id") String id) {
        return Response.ok()
                .entity(TelegramMapper.MAPPER.domainToDto((Telegram) notificationService.receiveMessage(id, channelKind)))
                .build();
    }

    @POST
    @Path("/post/")
    @ApiOperation(value = "CreateMessage")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postNotification(TelegramDTO telegramDto) {

        Telegram telegram = TelegramMapper.MAPPER.dtoToDomain(telegramDto);
        telegram = (Telegram) notificationService.sendMessage(telegram);
        telegramDto = TelegramMapper.MAPPER.domainToDto(telegram);
        return Response.status(201).entity(telegramDto).build();
    }
}
