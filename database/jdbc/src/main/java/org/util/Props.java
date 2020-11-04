package org.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Props {

    static Properties prop = new Properties();

    static {
        try (InputStream file = Props.class.getClassLoader().getResourceAsStream("database.properties")){
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }

}
