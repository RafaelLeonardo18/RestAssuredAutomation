package utils;

import java.util.Properties;

/**************************************************************************************************
* Descrição: classe utilitária que faz a configuração de ambiente da API
* Autor: Rafael Leonardo de Lima
* Data de criação: 17/11/2021
 * ************************************************************************************************/

public class PropertiesUtils {

    public static String getProperties(String key){
        Properties properties = new Properties();
        try {
            if (System.getProperty("env") == null){
                properties.load(PropertiesUtils.class.getClassLoader().getResourceAsStream("hom.properties"));
            } else {
                properties.load(PropertiesUtils.class.getClassLoader().getResourceAsStream(System.getProperty("env")));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}