package notificationService.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Converter <T>{
    private static final Logger LOGGER = LogManager.getLogger(Converter.class);

    public void convertToCSV(List <T> messages) {
        try {
            String path = EmailSender.path;
            File f = new File(path + "/emails.csv");
            FileWriter writer = new FileWriter(f, true);
            for (T message:messages) {
                writer.append(message.toString());
                writer.append("/n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
