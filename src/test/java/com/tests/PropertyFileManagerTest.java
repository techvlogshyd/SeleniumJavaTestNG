package com.tests;

import com.utils.PropertyFileManager;
import org.testng.annotations.Test;

public class PropertyFileManagerTest {

    @Test
    public void testPropertyFileManager(){
        PropertyFileManager propertyManager = new PropertyFileManager("/Users/prasanna/FrameWork/Automation/src/main/resources/testdata/config.properties");

        // Reading properties
        String username = propertyManager.getProperty("username");
        String password = propertyManager.getProperty("password");

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        // Writing properties
        propertyManager.setProperty("newProperty", "someValue");

        // Printing all properties
        propertyManager.printAllProperties();
    }
}
