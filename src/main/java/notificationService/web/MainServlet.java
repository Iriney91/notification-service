package notificationService.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import notificationService.component.TelegramSender;
import notificationService.model.ChannelKind;
import notificationService.model.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        TelegramSender telegramSender = new TelegramSender();
        Message message = telegramSender.readMessage("7ff8f90a-cb96-4429-8486-3ed863feefee", ChannelKind.TELEGRAM);

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