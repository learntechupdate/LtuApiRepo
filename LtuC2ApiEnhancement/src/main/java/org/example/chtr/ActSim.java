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
import java.util.Map.Entry;

public class ActSim {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // File path for the JSON file
        String filePath = "F:/automationFiles/Esimrequest.json";

        try (FileReader reader = new FileReader(filePath)) {
            // Parse the JSON file
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

            // Update all attribute values
            updateAllValues(jsonObject);

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

    private static void updateAllValues(JsonElement element) {
        if (element.isJsonObject()) {
            JsonObject jsonObject = element.getAsJsonObject();
            for (Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                if (entry.getValue().isJsonPrimitive() && entry.getValue().getAsJsonPrimitive().isString()
                ||entry.getValue().isJsonPrimitive() && entry.getValue().getAsJsonPrimitive().isBoolean()
                ) {
                    if(entry.getValue().getAsJsonPrimitive().isString()) {
                        // Append "updated" to all string values
                        jsonObject.addProperty(entry.getKey(), "$#&" + entry.getValue().getAsString() + "*@");
                    }
                    else {
                        jsonObject.addProperty(entry.getKey(),!entry.getValue().getAsJsonPrimitive().getAsBoolean() );
                    }
                }

                else {
                    // Recursively update nested objects and arrays
                    updateAllValues(entry.getValue());
                }

            }
        } else if (element.isJsonArray()) {
            JsonArray jsonArray = element.getAsJsonArray();
            for (JsonElement arrayElement : jsonArray) {
                updateAllValues(arrayElement);
            }
        }
    }
}

