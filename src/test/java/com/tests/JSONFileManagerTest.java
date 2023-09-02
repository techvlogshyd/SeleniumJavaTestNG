package com.tests;

import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.List;

public class JSONFileManagerTest {
    @Test
    public void testPropertyFileManager(){
        com.utils.JSONFileManager jsonFileManager = new com.utils.JSONFileManager("/Users/prasanna/FrameWork/Automation/src/main/resources/testdata/data.json");

        // Reading JSON
        System.out.println("Initial JSON Data: " + jsonFileManager.jsonObject.toString());

        // Writing JSON
        JSONObject newJSONObject = new JSONObject();
        newJSONObject.put("name", "John");
        newJSONObject.put("age", 30);
        jsonFileManager.jsonObject = newJSONObject;
        jsonFileManager.writeJSON();

        // Appending to JSON
        jsonFileManager.appendToJSON("hobbies", "Reading");
        jsonFileManager.appendToJSON("hobbies", "Gardening");

        // Reading JSON using JSONPath
        String name = (String) jsonFileManager.readValueUsingJsonPath("$.name");
        System.out.println("Name: " + name);

        List<String> hobbies = (List<String>) jsonFileManager.readValueUsingJsonPath("$.hobbies");
        System.out.println("Hobbies: " + hobbies.toString());
    }
}
