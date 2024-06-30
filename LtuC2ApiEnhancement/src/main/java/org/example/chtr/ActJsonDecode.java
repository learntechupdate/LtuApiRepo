package org.example.chtr;

import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * ActJsonDecode class
 *
 * @author touheed.aslam#Realme
 * @version 4.8
 * @updated 29-Jun-24
 * @since 4.8
 */
public class ActJsonDecode {

    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // File path for the JSON file
        String filePath = "F:/automationFiles/Esimrequest.json";

        try (FileReader reader = new FileReader(filePath)) {
            // Parse the JSON file
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

            String updatedJson = gson.toJson(jsonObject);
            System.out.println(updatedJson);

            JsonArray subOrderArray = jsonObject.get("data").getAsJsonObject().getAsJsonArray("subOrder");

            System.out.println("subOrderArray"+subOrderArray);
            int j=0;
            for (int i = 0; i <subOrderArray.size() ; i++) {
                JsonElement el = subOrderArray.get(i).getAsJsonObject()
                        .getAsJsonArray("deviceId").get(j).getAsJsonObject().get("type");
                System.out.println("el"+el);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
