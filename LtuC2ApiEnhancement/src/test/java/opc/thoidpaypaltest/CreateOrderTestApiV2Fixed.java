package opc.thoidpaypaltest;

import com.google.gson.Gson;
import io.restassured.response.Response;

import opc.thoidpaypal.createorderapiV2.request.CreateOrderRequestServiceV2;
import opc.thoidpaypal.createorderapiV2.response.CreateOrderResponsePojo;
import org.testng.annotations.Test;

/**
 * The type Create order test api v 2 fixed.
 */
public class CreateOrderTestApiV2Fixed {

    /**
     * Test create order api.
     */
    @Test
    public  void testCreateOrderApi(){

        CreateOrderRequestServiceV2 createOrderRequestService=new CreateOrderRequestServiceV2();

        Response response = createOrderRequestService.createOrderRequestService();

        System.out.println("response : "+response.asString());

        CreateOrderResponsePojo createOrderJavaResponse
                =new Gson().fromJson(response.asString(),CreateOrderResponsePojo.class);

        System.out.println("createOrderJavaResponse : "+createOrderJavaResponse);

        String id = createOrderJavaResponse.getId();
        System.out.println("id : "+id);
        String value = createOrderJavaResponse.getPurchase_units().get(0).getAmount().getBreakdown().getItem_total().getValue();
        System.out.println("value : "+value);
        String description = createOrderJavaResponse.getPurchase_units().get(0).getItems().get(0).getDescription();
        System.out.println("description : "+description);

    }

    /*o/p
    Reqbody : CreateOrderRequestPojoV2(intent=CAPTURE, purchase_units=[PurchaseUnit(items=[Item(name=T-Shirt, description=Green XL, quantity=1, unit_amount=UnitAmount(currency_code=USD, value=100.00))], amount=Amount(currency_code=USD, value=100.00, breakdown=Breakdown(item_total=ItemTotal(currency_code=USD, value=100.00))))], application_context=ApplicationContext(return_url=https://example.com/return, cancel_url=https://example.com/cancel))
    jsonBody : {"intent":"CAPTURE","purchase_units":[{"items":[{"name":"T-Shirt","description":"Green XL","quantity":"1","unit_amount":{"currency_code":"USD","value":"100.00"}}],"amount":{"currency_code":"USD","value":"100.00","breakdown":{"item_total":{"currency_code":"USD","value":"100.00"}}}}],"application_context":{"return_url":"https://example.com/return","cancel_url":"https://example.com/cancel"}}
    response : {"id":"6R063002CU050300S","intent":"CAPTURE","status":"CREATED","purchase_units":[{"reference_id":"default","amount":{"currency_code":"USD","value":"100.00","breakdown":{"item_total":{"currency_code":"USD","value":"100.00"}}},"payee":{"email_address":"john_merchant@example.com","merchant_id":"C7CYMKZDG8D6E"},"soft_descriptor":"JOHNMERCHAN","items":[{"name":"T-Shirt","unit_amount":{"currency_code":"USD","value":"100.00"},"quantity":"1","description":"Green XL"}]}],"create_time":"2023-11-11T10:47:48Z","links":[{"href":"https://api.sandbox.paypal.com/v2/checkout/orders/6R063002CU050300S","rel":"self","method":"GET"},{"href":"https://www.sandbox.paypal.com/checkoutnow?token=6R063002CU050300S","rel":"approve","method":"GET"},{"href":"https://api.sandbox.paypal.com/v2/checkout/orders/6R063002CU050300S","rel":"update","method":"PATCH"},{"href":"https://api.sandbox.paypal.com/v2/checkout/orders/6R063002CU050300S/capture","rel":"capture","method":"POST"}]}
    createOrderJavaResponse : CreateOrderResponsePojo(id=6R063002CU050300S, intent=CAPTURE, status=CREATED, purchase_units=[PurchaseUnit(reference_id=default, amount=Amount(currency_code=USD, value=100.00, breakdown=Breakdown(item_total=ItemTotal(currency_code=USD, value=100.00))), payee=Payee(email_address=john_merchant@example.com, merchant_id=C7CYMKZDG8D6E), soft_descriptor=JOHNMERCHAN, items=[Item(name=T-Shirt, unit_amount=UnitAmount(currency_code=USD, value=100.00), quantity=1, description=Green XL)])], create_time=Sat Nov 11 16:17:48 IST 2023, links=[Link(href=https://api.sandbox.paypal.com/v2/checkout/orders/6R063002CU050300S, rel=self, method=GET), Link(href=https://www.sandbox.paypal.com/checkoutnow?token=6R063002CU050300S, rel=approve, method=GET), Link(href=https://api.sandbox.paypal.com/v2/checkout/orders/6R063002CU050300S, rel=update, method=PATCH), Link(href=https://api.sandbox.paypal.com/v2/checkout/orders/6R063002CU050300S/capture, rel=capture, method=POST)])
    id : 6R063002CU050300S
    value : 100.00
    description : Green XL
     */
}
