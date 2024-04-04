package opc.thoidpaypal.createorderapiV2.request;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

/**
 * The type Create order request api.
 */
public class CreateOrderRequestAPI {

    /**
     * Post api response.
     *
     * @param url     the url
     * @param headers the headers
     * @param reqBody    the body
     * @return the response
     */
    public Response postApi(String url, Map<String,String> headers, String reqBody){
        Response response;
        RequestSpecification reqSpc= RestAssured.given();
        reqSpc.headers(headers);

        reqSpc.body(reqBody);//internally convert java pojo to json
        System.out.println("jsonBody : "+reqBody);
        response=reqSpc.post(url);
        return response;
    }
}
