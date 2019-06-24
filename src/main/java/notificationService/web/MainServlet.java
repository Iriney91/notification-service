package notificationService.web;

import notificationService.model.Telegram;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/notification-service/telegram/*")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

//        File f = new File("123-ss.json");
//        FileWriter fw = new FileWriter(f);
//        fw.write("{\"sss\":1222}");
//        fw.flush();
//        fw.close();

        OutputStream out = resp.getOutputStream();

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String id = req.getPathInfo().substring(1);

        if (id.equals("all")) {
            // read all files from dir
        } else {
            InputStream initialStream = new FileInputStream(new File(id + ".json"));
            byte[] buffer = new byte[initialStream.available()];
            initialStream.read(buffer);

            out.write(buffer);
        }
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        super.doPost(req, resp);
    }
}
