package org.example.jsonDefaulandUpdateUsingJsonObject;

/**
 * JsonUpdateExample class
 *
 * @author touheed.aslam#Realme
 * @version 4.8
 * @updated 29-Jun-24
 * @since 4.8
 */

import com.google.gson.*;

import java.io.FileReader;
import java.io.IOException;

public class JsonUpdateExample {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String filePath = "./src/main/java/org/example/jsonDefaulandUpdateUsingJsonObject/capture_request.json";

        try (FileReader reader = new FileReader(filePath)) {
            // Parse JSON to JsonObject

            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

            // Update intent
            jsonObject.addProperty("intent", "AUTHORIZE updatednew");

            jsonObject.remove("intent");//!!!
            // Update purchase_units

            JsonArray purchaseUnits = jsonObject.getAsJsonArray("purchase_units");
            jsonObject.remove("purchase_units");//!!!
            if (purchaseUnits.size() > 0) {
                JsonObject firstPurchaseUnit = purchaseUnits.get(0).getAsJsonObject();

                // Update items
                JsonArray items = firstPurchaseUnit.getAsJsonArray("items");
                if (items.size() > 0) {
                    JsonObject firstItem = items.get(0).getAsJsonObject();
                    firstItem.addProperty("name", "Updated T-Shirt updatednew");
                    firstItem.addProperty("description", "Blue XL updatednew");
                }

                // Update amount
                JsonObject amount = firstPurchaseUnit.getAsJsonObject("amount");
                amount.addProperty("value", "160.00");

                // Update breakdown
                JsonObject breakdown = amount.getAsJsonObject("breakdown");
                JsonObject itemTotal = breakdown.getAsJsonObject("item_total");
                itemTotal.addProperty("value", "160.00");
            }

            // Update application_context
            JsonObject applicationContext = jsonObject.getAsJsonObject("application_context");
            applicationContext.addProperty("return_url", "https://example.com/updatednew_return");
            applicationContext.addProperty("cancel_url", "https://example.com/updatednew_cancel");

            // Convert updated JsonObject to JSON string
            String updatedJson = gson.toJson(jsonObject);
            System.out.println(updatedJson);

            /*// Write updated JSON to file
            try (FileWriter writer = new FileWriter(filePath)) {
                gson.toJson(jsonObject, writer);
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

