package utils;

import java.util.Properties;

public class PropertiesUtils {

    Properties properties = new Properties();

    public String getProperties(String key){
        try {
            if (System.getProperty("env") == null){
                properties.load(getClass().getClassLoader().getResourceAsStream("hom.properties"));
            } else {
                properties.load(getClass().getClassLoader().getResourceAsStream(System.getProperty("env")));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}
