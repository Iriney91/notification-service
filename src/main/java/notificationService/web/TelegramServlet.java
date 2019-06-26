package notificationService.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import notificationService.model.ChannelKind;
import notificationService.model.Message;
import notificationService.model.Telegram;
import notificationService.service.NotificationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/notification-service/telegram")
public class TelegramServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
//1d35f292-5ee7-4f95-b629-cdeee6d34797"

        NotificationService notificationService = NotificationService.getInstance();
        ObjectMapper mapper = new ObjectMapper();

        switch (req.getParameter("action").toLowerCase()) {
            case "getall":
                List<Message> messages = notificationService.receiveMessages(ChannelKind.TELEGRAM);
                try {
                    PrintWriter ww = resp.getWriter();
                    ww.print("[");
                    Boolean isFirst = true;
                    for (Message msg : messages) {
                        if (isFirst) {
                            isFirst = false;
                        } else {
                            ww.print(",");
                        }
                        String myjson = mapper.writeValueAsString(msg);
                        ww.print(myjson);
                        ww.flush();
                    }
                    ww.print("]");
                    ww.close();
                } catch (IOException e) {
                    e.getMessage();
                }
                break;
            case "getbyid":
                String id = req.getParameter("id");
                Message message = notificationService.receiveMessage(id, ChannelKind.TELEGRAM);

                try {
                    String mjson = mapper.writeValueAsString(message);
                    PrintWriter w = resp.getWriter();
                    w.print(mjson);
                    w.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader reader = req.getReader();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } finally {
            reader.close();
        }

        System.out.println(sb.toString());

        ObjectMapper mapper = new ObjectMapper();
        Telegram message = mapper.readValue(sb.toString(), Telegram.class);

        System.out.println(message.toString());
        System.out.println(message.getId());
        System.out.println(message.getSendDate());
        System.out.println(message.getText());
        System.out.println(message.getChannelKind());

        NotificationService.getInstance().sendMessage(message);
    }
}