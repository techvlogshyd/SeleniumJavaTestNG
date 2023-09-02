package com.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import com.jayway.jsonpath.JsonPath;
import org.json.JSONTokener;

import java.io.*;

public class JSONFileManager {
    private String filePath;
    public JSONObject jsonObject;

    public JSONFileManager(String filePath) {
        this.filePath = filePath;
        this.jsonObject = readJSON();
    }

    private JSONObject readJSON() {
        try {
            FileReader fileReader = new FileReader(filePath);
            JSONTokener jsonTokener = new JSONTokener(fileReader);
            return new JSONObject(jsonTokener);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    public void writeJSON() {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            jsonObject.write(fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void appendToJSON(String key, Object value) {
        if (jsonObject.has(key)) {
            Object existingValue = jsonObject.get(key);
            if (existingValue instanceof JSONArray) {
                ((JSONArray) existingValue).put(value);
            } else {
                JSONArray newArray = new JSONArray();
                newArray.put(existingValue);
                newArray.put(value);
                jsonObject.put(key, newArray);
            }
        } else {
            jsonObject.put(key, value);
        }

        writeJSON();
    }

    public Object readValueUsingJsonPath(String jsonPath) {
        return JsonPath.read(jsonObject.toString(), jsonPath);
    }
}

