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

public class ActSim3 {
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
            attribueUpdate.put("requestType","hana");
            attribueUpdate.put("zipCode","560043");
            attribueUpdate.put("deviceId:0:type","IMEI2New");
            attribueUpdate.put("deviceId:1:type","4GNew");

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


        if (element.isJsonObject()) {
            JsonObject jsonObject = element.getAsJsonObject();
            for (Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                if (entry.getValue().isJsonPrimitive() && entry.getValue().getAsJsonPrimitive().isString()) {
                    // Append "updated" to all string values
                    if(attribueUpdate.containsKey(entry.getKey())) {
                        jsonObject.addProperty(entry.getKey(),attribueUpdate.get(entry.getKey()) );
                    }
                }
                else {
                    // Recursively update nested objects and arrays
                    updateDefaultValues(entry.getValue(),attribueUpdate);
                }
            }
        } else if (element.isJsonArray()) {
            JsonArray jsonArray = element.getAsJsonArray();
            for (JsonElement arrayElement : jsonArray) {

//                for (String key : attribueUpdate.keySet()) {
                    if (arrayElement.getAsString().contains("Array")) {
                        String[] parts = arrayElement.getAsString().split(":");
                        String keyInput = parts[0];
                        String ArrayIndex = parts[1].split("#")[1];
                        String keyValueInput = parts[2];
                      /*  // Construct the updated key and value
                        String updatedKey = keyInput;
                        String updatedValue = keyValueInput;
                        // Put the update into the updates map
                        updates.put(updatedKey, attribueUpdate.get(key));*/

//                }

//                JsonArray subOrderArray = jsonObject.get("data").getAsJsonObject().getAsJsonArray("subOrder");
//                System.out.println("subOrderArray"+subOrderArray);
                        JsonElement arrayElement2 = null;
                        int j = Integer.parseInt(ArrayIndex);
                        for (int i = 0; i < jsonArray.size(); i++) {
                             arrayElement2 = jsonArray.get(i).getAsJsonObject()
                                    .getAsJsonArray(keyInput).get(j).getAsJsonObject().get(keyValueInput);
                            System.out.println("el" + arrayElement2);
                        }
                        //                arrayElement
                        updateDefaultValues(arrayElement2,attribueUpdate);
                    }

            }
        }
    }
}

