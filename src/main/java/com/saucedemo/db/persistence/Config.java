package com.saucedemo.db.persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    public static String DRIVER;
    public static String URL;
    public static String USER_NAME;
    public static String PASSWORD;
    public static Integer POOL_SIZE;

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/_database.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);

            DRIVER = properties.getProperty("db.driver");
            URL = properties.getProperty("db.url");
            USER_NAME = properties.getProperty("db.user");
            PASSWORD = properties.getProperty("db.pass");
            POOL_SIZE = Integer.valueOf(properties.getProperty("poolSize"));
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}