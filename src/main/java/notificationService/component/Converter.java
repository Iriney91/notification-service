package notificationService.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import notificationService.model.Message;
import notificationService.model.PushNotification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.List;

public class Converter {
    private static final Logger LOGGER = LogManager.getLogger(Converter.class);

    public static void convertToCSV(List<Message> messages) {
        try {
            String path = EmailSender.emailpath;
            File f = new File(path + "\\emails.csv");
            FileWriter writer = new FileWriter(f, true);
            for (Message message : messages) {
                writer.append(message.toString());
                writer.append("\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static void convertToXML(List<Message> messages, String path) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PushNotification.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            for (Message message : messages) {
                File file = new File(path + "\\" + message.getId() + ".xml");
                jaxbMarshaller.marshal(message, file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void convertToJson(List<Message> messages, String path) {

        ObjectMapper mapper = new ObjectMapper();
        for (Message message : messages) {
            try {
                File f = new File(path + "\\" + message.getId() + ".json");
                mapper.writeValue(f, message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void Serialize(List<Message> messages, String path) {
        for (Message message : messages) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                        new FileOutputStream(path + "\\" + message.getId() + ".out"));
                objectOutputStream.writeObject(message);
                objectOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
