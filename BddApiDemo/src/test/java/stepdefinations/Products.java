package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;

public class Products {

    public RequestSpecification httpRequest;
    public Response response;

    @Given("I hit url of get products api endpoint")
    public void I_hit_url_of_get_products_api_endpoint () {
     RestAssured.baseURI="https://fakestoreapi.com";

    }

    @When("I pass the url of products in the request")
    public void i_pass_the_url_of_products_in_the_request() {
        httpRequest=RestAssured.given();
        response=httpRequest.get("products");
    }
    @Then("I recevie the response code as {int}")
    public void i_recevie_the_response_code_as(Integer eStatusCode) {
        int aStatusCode = response.getStatusCode();
//        System.out.println(aStatusCode);
        Assert.assertEquals(aStatusCode,eStatusCode);
    }

}

