package org.example.jsonfiletopojo;

/**
 * JsonToPojoExample class
 *
 * @author touheed.aslam#Realme
 * @version 4.8
 * @updated 29-Jun-24
 * @since 4.8
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.jsonfiletopojo.javapojo.CaptureRequestPojo;
import org.example.jsonfiletopojo.javapojo.Item;
import org.example.jsonfiletopojo.javapojo.PurchaseUnit;

import java.io.FileReader;
import java.io.IOException;

public class JsonToPojoExample {
    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileReader reader = new FileReader("./src/main/java/org/example/jsonfiletopojo/capture_request.json")) {
            // Deserialize JSON to Java object
            CaptureRequestPojo request = gson.fromJson(reader, CaptureRequestPojo.class);

            // Update attributes
            request.setIntent("AUTHORIZE");
            if (!request.getPurchase_units().isEmpty()) {
                PurchaseUnit firstUnit = request.getPurchase_units().get(0);
                if (!firstUnit.getItems().isEmpty()) {
                    Item firstItem = firstUnit.getItems().get(0);
                    firstItem.setName("Updated T-Shirt");
                    firstItem.setDescription("Blue XL");
                }
                firstUnit.getAmount().setValue("120.00");
                firstUnit.getAmount().getBreakdown().getItem_total().setValue("120.00");
            }
            request.getApplication_context().setReturn_url("https://example.com/updated_return");
            request.getApplication_context().setCancel_url("https://example.com/updated_cancel");
            // Convert updated object back to JSON
            String updatedJson = gson.toJson(request);
            System.out.println(updatedJson);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

