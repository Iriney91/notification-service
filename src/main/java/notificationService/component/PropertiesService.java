package notificationService.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesService {

    private static final Logger LOGGER = LogManager.getLogger(PropertiesService.class);

    private static final Properties properties = new Properties();

    public static String getFilePath(String path) {
        String messagePath = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);
            fis.close();
            messagePath = properties.getProperty("message.path");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return messagePath;
    }
}
