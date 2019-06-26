package notificationService.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import notificationService.component.TelegramSender;
import notificationService.model.ChannelKind;
import notificationService.model.Message;
import notificationService.model.Telegram;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet("/")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        TelegramSender telegramSender = new TelegramSender();
        Message message = telegramSender.readMessage("9caee835-dfa2-49c5-b1d5-c7a4723f4958", ChannelKind.TELEGRAM);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        ObjectMapper mapper = new ObjectMapper();
        try {
            String mjson = mapper.writeValueAsString(message);
            System.out.println(mjson);
            PrintWriter w = resp.getWriter();
            w.print(mjson);
            w.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}