package opc.thoidpaypaltest;

import io.restassured.response.Response;
import opc.thoidpaypal.createorderapi.CreateOrderRequest;
import org.testng.annotations.Test;

public class CreateOrderTestAPI {

    @Test
    public  void testCreateOrderApi(){

        CreateOrderRequest createOrderTestAPI=new CreateOrderRequest();


        String url="https://api-m.sandbox.paypal.com/v2/checkout/orders";
        String body="{\n" +
                "    \"intent\": \"CAPTURE\",\n" +
                "    \"purchase_units\": [\n" +
                "        {\n" +
                "            \"items\": [\n" +
                "                {\n" +
                "                    \"name\": \"T-Shirt\",\n" +
                "                    \"description\": \"Green XL\",\n" +
                "                    \"quantity\": \"1\",\n" +
                "                    \"unit_amount\": {\n" +
                "                        \"currency_code\": \"USD\",\n" +
                "                        \"value\": \"100.00\"\n" +
                "                    }\n" +
                "                }\n" +
                "            ],\n" +
                "            \"amount\": {\n" +
                "                \"currency_code\": \"USD\",\n" +
                "                \"value\": \"100.00\",\n" +
                "                \"breakdown\": {\n" +
                "                    \"item_total\": {\n" +
                "                        \"currency_code\": \"USD\",\n" +
                "                        \"value\": \"100.00\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"application_context\": {\n" +
                "        \"return_url\": \"https://example.com/return\",\n" +
                "        \"cancel_url\": \"https://example.com/cancel\"\n" +
                "    }\n" +
                "}";
        Response response = createOrderTestAPI.postApi(url, body);

        System.out.println(response.asString());

    }
}
