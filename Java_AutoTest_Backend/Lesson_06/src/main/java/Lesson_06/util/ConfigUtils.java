package Lesson_06.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class ConfigUtils {

    Properties properties = new Properties();
    private static InputStream configFile;

    static {
        try {
            configFile = new
                    FileInputStream("src/test/resources/my.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public String getBaseUrl() {
        properties.load(configFile);
        return properties.getProperty("URL");
    }
}
