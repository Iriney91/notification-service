package notificationService.component;

import au.com.bytecode.opencsv.CSVWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import notificationService.model.ChannelKind;
import notificationService.model.Message;
import notificationService.model.PushNotification;
import notificationService.model.Telegram;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Converter {
    private static final Logger LOGGER = LogManager.getLogger(Converter.class);

//    public static void convertToCSV(List<Message> messages) {
//        try {
//            String path = EmailMessager.emailpath;
//            File f = new File(path + "/emails.csv");
//            FileWriter writer = new FileWriter(f, true);
//            for (Message message : messages) {
//                writer.append(message.toString());
//                writer.append("\n");
//            }
//            writer.flush();
//            writer.close();
//        } catch (IOException e) {
//            LOGGER.error(e.getMessage());
//        }
//    }

    public static void main(List<Message> messages) {
        String path = EmailMessager.emailpath;
        try{
        CSVWriter writer = new CSVWriter(new FileWriter(path + "/emails.csv", true));
        //Create record
        for (Message message : messages) {
            String[] record = (message.getId()+ message.getCreationDate()+message.getChannelKind()+message.getText()+ message.getSendDate()).split(";");
            //Write the record to file
            writer.writeNext(record);
            //close the writer
            writer.close();

        }}catch (IOException e){
            e.getMessage();
        }
    }

    public static void convertToXML(List<Message> messages, String path) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PushNotification.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            for (Message message : messages) {
                File file = new File(path + File.separator + message.getId() + ".xml");
                jaxbMarshaller.marshal(message, file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//
//    public  static Message convertForXML(){
//
//        File xmlFile = new File("employee.xml");
//
//        JAXBContext jaxbContext;
//        try
//        {
//            jaxbContext = JAXBContext.newInstance(Employee.class);
//
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//
//            Employee employee = (Employee) jaxbUnmarshaller.unmarshal(xmlFile);
//
//            System.out.println(employee);
//        }
//        catch (JAXBException e)
//        {
//            e.printStackTrace();
//        }
//        return  null;
//    }

    public static void convertToJson(List<Message> messages, String path) {

        ObjectMapper mapper = new ObjectMapper();
        for (Message message : messages) {
            try {
                File f = new File(path + File.separator + message.getId() + ".json");
                mapper.writeValue(f, message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Message convertFromJson(ChannelKind channelKind, String path, String id) {
        ObjectMapper mapper = new ObjectMapper();
        String filepath = path + File.separator + id + ".json";
        System.out.println(filepath);

        try {
            switch (channelKind) {
                case TELEGRAM:
                    Message m = mapper.readValue(new FileInputStream(filepath), Telegram.class);
                    return m;
            }
        } catch (IOException e) {
            LOGGER.debug(e.getMessage());
        }
        return null;
    }

    public static List<Message> convertFromJson(ChannelKind channelKind, String path) {
        ObjectMapper mapper = new ObjectMapper();
        List<Message> messages = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {
            List<String> files = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());

            for (String file : files) {

                switch (channelKind) {
                    case TELEGRAM:
                        messages.add(mapper.readValue(new FileInputStream(file), Telegram.class));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return messages;
    }


    public static void Serialize(List<Message> messages, String path) {
        for (Message message : messages) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                        new FileOutputStream(path + File.separator + message.getId() + ".out"));
                objectOutputStream.writeObject(message);
                objectOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
