package org.example.jsonMergeDefaulAndUpdateTestData;

/**
 * JsonMergeExample class
 *
 * @author touheed.aslam#Realme
 * @version 4.8
 * @updated 29-Jun-24
 * @since 4.8
 */
import com.google.gson.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class JsonMergeExample {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String originalFilePath = "./src/main/java/org/example/jsonMergeDefaulAndUpdateTestData/capture_request.json";
        String updateFilePath = "./src/main/java/org/example/jsonMergeDefaulAndUpdateTestData/capture_requestNegativeTestData.json";

        try (FileReader originalReader = new FileReader(originalFilePath);
             FileReader updateReader = new FileReader(updateFilePath)) {

            // Parse both JSON files into JsonObject
            JsonObject originalJson = JsonParser.parseReader(originalReader).getAsJsonObject();
            JsonObject updateJson = JsonParser.parseReader(updateReader).getAsJsonObject();

            // Merge the JSON objects
            JsonObject mergedJson = mergeJsonObjects(originalJson, updateJson);

            // Convert merged JsonObject to JSON string and write to file
           /* try (FileWriter writer = new FileWriter(originalFilePath)) {
                gson.toJson(mergedJson, writer);
            }*/

            // Print the updated JSON to console
            String updatedJson = gson.toJson(mergedJson);
            System.out.println(updatedJson);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JsonObject mergeJsonObjects(JsonObject original, JsonObject update) {
        for (Map.Entry<String, JsonElement> entry : update.entrySet()) {
            String key = entry.getKey();
            JsonElement originalValue = original.get(key);
            JsonElement updateValue = entry.getValue();

            if (originalValue != null && originalValue.isJsonObject() && updateValue.isJsonObject()) {
                JsonObject mergedObject = mergeJsonObjects(originalValue.getAsJsonObject(), updateValue.getAsJsonObject());
                original.add(key, mergedObject);
            } else if (originalValue != null && originalValue.isJsonArray() && updateValue.isJsonArray()) {
                JsonArray mergedArray = mergeJsonArrays(originalValue.getAsJsonArray(), updateValue.getAsJsonArray());
                original.add(key, mergedArray);
            } else {
                original.add(key, updateValue);
            }
        }
        return original;
    }

    private static JsonArray mergeJsonArrays(JsonArray original, JsonArray update) {
        for (int i = 0; i < update.size(); i++) {
            JsonElement updateElement = update.get(i);
            if (i < original.size()) {
                JsonElement originalElement = original.get(i);
                if (originalElement.isJsonObject() && updateElement.isJsonObject()) {
                    JsonObject mergedElement = mergeJsonObjects(originalElement.getAsJsonObject(), updateElement.getAsJsonObject());
                    original.set(i, mergedElement);
                } else {
                    original.set(i, updateElement);
                }
            } else {
                original.add(updateElement);
            }
        }
        return original;
    }
}


