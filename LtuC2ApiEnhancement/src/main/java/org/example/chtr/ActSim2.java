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

public class ActSim2 {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // File path for the JSON file
        String filePath = "F:/automationFiles/Esimrequest.json";

        try (FileReader reader = new FileReader(filePath)) {
            // Parse the JSON file
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

            // Update update Default Values values
            Map<String ,String> attribueUpdate=new HashMap<>();
            attribueUpdate.put("serviceId","bescom");
//            attribueUpdate.put("requestType","hana");
//            attribueUpdate.put("zipCode","560043");
            attribueUpdate.put("featureCode","featureCodeNew");
            attribueUpdate.put("deviceId:Array#0:type", "IMEI2New");
            attribueUpdate.put("feature:Array#1:featureCode", "HeyFeature");
            updateDefaultValues(jsonObject,attribueUpdate);

            // Write the updated JSON object back to the file (optional)
            /*try (FileWriter writer = new FileWriter(filePath)) {
                writer.write(jsonObject.toString());
            }*/

            // Print the updated JSON object
            // Convert updated JsonObject to JSON string
            String updatedJson = gson.toJson(jsonObject);
            System.out.println(updatedJson);
//            System.out.println(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateDefaultValues(JsonElement element,Map<String ,String> attribueUpdate) {

       String JsonElementCustom= String.valueOf(element);
        if (element.isJsonObject()) {
            JsonObject jsonObject = element.getAsJsonObject();
            for (Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                if (entry.getValue().isJsonPrimitive() && entry.getValue().getAsJsonPrimitive().isString()) {
                    // Append "updated" to all string values
                    if(attribueUpdate.containsKey(entry.getKey())) {
                        jsonObject.addProperty(entry.getKey(),attribueUpdate.get(entry.getKey()) );
                    }

//                    attribueUpdate.put("deviceId:Array#0:type", "IMEI2New");
//                    attribueUpdate.put("feature:Array#1:featureCode", "HeyFeature");
                    /*if (attribueUpdate.containsKey("deviceId:Array#0:type")) {

                        String[] parts = "deviceId:Array#0:type".split(":");
                        String keyInput = parts[0];
                        String ArrayIndex = parts[1].split("#")[1];
                        String keyValueInput = parts[2];

                        attribueUpdate.containsKey("keyInput");
                      *//*  // Construct the updated key and value
                        String updatedKey = keyInput;
                        String updatedValue = keyValueInput;
                        // Put the update into the updates map
                        updates.put(updatedKey, attribueUpdate.get(key));*//*
                        updateDefaultValues(entry.getValue(),attribueUpdate);
                    }*/

                }
                else {
                    // Recursively update nested objects and arrays
                    updateDefaultValues(entry.getValue(),attribueUpdate);
                }
            }
        } else if (element.isJsonArray()) {
            JsonArray jsonArray = element.getAsJsonArray();
            for (JsonElement arrayElement : jsonArray) {
                updateDefaultValues(arrayElement,attribueUpdate);
            }
        }
    }
}

