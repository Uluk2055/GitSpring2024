package demoqa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    private ConfigReader(){

    }

    static {
        try {
            String path = "src/main/resources/app.properties";
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    static {
//        try {
//            InputStream fileInputStream = ConfigReader.class.getClassLoader().getResourceAsStream("app.properties");
//            properties = new Properties();
//            properties.load(fileInputStream);
//            fileInputStream.close();
//        } catch (IOException e) {
//            throw new RuntimeException("File not found");
//        }
//    }

    public static String getValue(String key) {
        return properties.getProperty(key.trim());
    }
}
