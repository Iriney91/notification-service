package notificationService.web.rest;

import notificationService.model.ChannelKind;
import notificationService.model.Telegram;
import notificationService.model.rest.SendMessageRequest;
import notificationService.model.rest.SendMessageResponse;
import notificationService.service.NotificationService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotification(@PathParam("ChannelKind")ChannelKind channelKind) {
        return Response.ok()
                .entity(notificationService.receiveMessages(channelKind))
                .build();
    }

    @GET
    @Path("/get/{ChannelKind}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotification(@PathParam("ChannelKind")ChannelKind channelKind, @PathParam("id")String id) {
        return Response.ok()
                .entity(notificationService.receiveMessage(id, channelKind))
                .build();
    }

//    @POST
//    @Path("/post/")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response postNotification(Notification notification) {
//        return Response.status(201).entity(notification).build();
//    }

    @POST
    @Path("/post/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postNotification(SendMessageRequest request) {

        Telegram message = new Telegram(request.getText(), request.getSendDate(), request.getPhone());
        SendMessageResponse response = new SendMessageResponse();
        return Response.status(201).entity(response.setTelegram((Telegram)notificationService.sendMessage(message))).build();
    }
}
