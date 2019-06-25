package notificationService.web;

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

        try (Stream < Path > walk = Files.walk(Paths.get("C:\\Users\\User\\IdeaProjects\\notification-service\\telegram"))){
            List<String> result = walk.filter(Files::isRegularFile)
                    .map(x -> Files.readAllBytes(x)).collect(Collectors.toList());
            PrintWriter w = resp.getWriter();
//            String contents = Files.readAllBytes(Paths.get());
            w.print(result);
            w.flush();
        }catch (IOException e){
            e.getMessage();
        }

    }
//        OutputStream out = resp.getOutputStream();
//
//        resp.setContentType("application/json");
//        resp.setCharacterEncoding("UTF-8");
//
//        String id = req.getPathInfo().substring(1);
//
//        if (id.equals("all")) {
//            // read all files from dir
//        } else {
//            InputStream initialStream = new FileInputStream(new File(id + ".json"));
//            byte[] buffer = new byte[initialStream.available()];
//            initialStream.read(buffer);
//
//            out.write(buffer);
//        }
//        out.flush();
//    }
}