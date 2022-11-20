package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GettingProperties {

    public static final String JDBC_DRIVER;
    public static final String DB_URL;
    public static final String USER;
    public static final String PASS;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream
                    ("./src/resources/config.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JDBC_DRIVER = properties.getProperty("JDBC_DRIVER");
        DB_URL = properties.getProperty("DB_URL");
        USER = properties.getProperty("USER");
        PASS = properties.getProperty("PASS");
    }

}

