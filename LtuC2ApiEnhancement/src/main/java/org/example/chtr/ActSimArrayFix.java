package org.example.chtr;

/**
 * actSim class
 *
 * @author touheed.aslam#Realme
 * @version 4.8
 * @updated 29-Jun-24
 * @since 4.8
 */
import com.google.gson.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ActSimArrayFix {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // File path for the JSON file
        String filePath = "F:/automationFiles/Esimrequest.json";

        try (FileReader reader = new FileReader(filePath)) {
            // Parse the JSON file
            JsonElement jsonElement = JsonParser.parseReader(new JsonReader(reader));

            // Update default values
            Map<String, String> attributeUpdate = new HashMap<>();
            attributeUpdate.put("serviceId", "bescom");
            attributeUpdate.put("requestType", "hana");
            attributeUpdate.put("zipCode", "560043");
            attributeUpdate.put("featureCode", "featureCode1");

            updateDefaultValues(jsonElement, attributeUpdate);

            // Convert updated JsonElement to JSON string
            String updatedJson = gson.toJson(jsonElement);
            System.out.println(updatedJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateDefaultValues(JsonElement element, Map<String, String> attributeUpdate) {
        if (element.isJsonObject()) {
            JsonObject jsonObject = element.getAsJsonObject();
            for (Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                if (entry.getValue().isJsonPrimitive() && entry.getValue().getAsJsonPrimitive().isString()) {
                    // Update values based on attributeUpdate map
                    String attributeName = entry.getKey();
                    if (attributeUpdate.containsKey(attributeName)) {
                        jsonObject.addProperty(attributeName, attributeUpdate.get(attributeName));
                    }
                } else {
                    // Recursively update nested objects and arrays
                    updateDefaultValues(entry.getValue(), attributeUpdate);
                }
            }
        } else if (element.isJsonArray()) {
            JsonArray jsonArray = element.getAsJsonArray();
            for (JsonElement arrayElement : jsonArray) {
                if (arrayElement.isJsonObject()) {
                    JsonObject obj = arrayElement.getAsJsonObject();
                    // Example: Check and update featureCode only if it matches specific value
                    if (obj.has("feature") && obj.get("feature").isJsonArray()) {
                        JsonArray featuresArray = obj.getAsJsonArray("feature");
                        for (JsonElement featureElement : featuresArray) {
                            if (featureElement.isJsonObject()) {
                                JsonObject featureObj = featureElement.getAsJsonObject();
                                if (featureObj.has("featureCode") && featureObj.get("featureCode").isJsonPrimitive()
                                        && featureObj.get("featureCode").getAsString().equals("featureCode1")) {
                                    featureObj.addProperty("subscribe", true); // Example update
                                }
                            }
                        }
                    }
                }
                // Recursively update all elements in the array
                updateDefaultValues(arrayElement, attributeUpdate);
            }
        }
    }
}


