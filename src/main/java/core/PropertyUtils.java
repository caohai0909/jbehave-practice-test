package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static core.Page.getProjectPath;

public class PropertyUtils {
    public static Properties property;
    //private static String configPath = "\\configuration.properties";

    public static void initializePropertyFile(String configPath)  {
        property = new Properties();
        try {
            InputStream inputStream = new FileInputStream(getProjectPath() + configPath);
            property.load(inputStream);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
