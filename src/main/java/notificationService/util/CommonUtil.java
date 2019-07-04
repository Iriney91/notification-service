package notificationService.util;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CommonUtil {

    private CommonUtil() {
    }

    public static File getFileByName(Path path, String fileName) throws IOException {
        return Files.walk(path)
                .map(Path::toFile)
                .filter(file -> file.getName().contains(fileName))
                .findFirst().orElseThrow(FileNotFoundException::new);
    }

    public static List<File> getAllFiles(Path path, Predicate<File> predicate) throws IOException {
        return Files.walk(path)
                .map(Path::toFile)
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static Properties readProperty(String fileName) {

        ClassLoader classLoader = CommonUtil.class.getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new RuntimeException("File not found: " + fileName);
        }
        System.out.println(resource.toString());
        File file = new File(resource.getFile());

        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(file)) {
            prop.load(input);
            return prop;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

}