package com.utils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileManager {
    private Properties properties;
    private String filePath;

    public PropertyFileManager(String filePath) {
        this.filePath = filePath;
        this.properties = new Properties();
        loadProperties();
    }

    private void loadProperties() {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
        saveProperties();
    }

    private void saveProperties() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            properties.store(fileOutputStream, null);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printAllProperties() {
        properties.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static void main(String[] args) {

    }
}
