package org.example.chtr;

/**
 * ActSimArrayFix4 class
 *
 * @author touheed.aslam#Realme
 * @version 4.8
 * @updated 29-Jun-24
 * @since 4.8
 */

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ActSimArrayFix4 {

        public static void main(String[] args) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            // File path for the JSON file
            String filePath = "F:/automationFiles/Esimrequest.json";

            try (FileReader reader = new FileReader(filePath)) {
                // Parse the JSON file
                JsonElement jsonElement = JsonParser.parseReader(new JsonReader(reader));

                // Update values at specific indices
                updateValuesAtIndex(jsonElement, "data.subOrder[0].additionalData[0].value", "newUpdatedValue");

                // Convert updated JsonElement to JSON string
                String updatedJson = gson.toJson(jsonElement);
                System.out.println(updatedJson);

                // Optionally, write the updated JSON back to file
            /*try (FileWriter writer = new FileWriter(filePath)) {
                gson.toJson(jsonElement, writer);
            }*/
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void updateValuesAtIndex(JsonElement element, String jsonPath, String newValue) {
            JsonElement targetElement = getElementAtPath(element, jsonPath);
            if (targetElement != null && targetElement.isJsonPrimitive()) {
                // Replace the old JsonPrimitive with a new one
//                targetElement.getAsJsonPrimitive().
            }
        }

        private static JsonElement getElementAtPath(JsonElement element, String jsonPath) {
            String[] pathComponents = jsonPath.split("\\.");
            JsonElement currentElement = element;

            for (String pathComponent : pathComponents) {
                if (currentElement.isJsonObject()) {
                    currentElement = currentElement.getAsJsonObject().get(pathComponent);
                } else if (currentElement.isJsonArray()) {
                    try {
                        int index = Integer.parseInt(pathComponent);
                        currentElement = currentElement.getAsJsonArray().get(index);
                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        return null;
                    }
                } else {
                    return null;
                }
            }

            return currentElement;
        }
    }
