package com.typicodeJsonplaceholder;

import io.restassured.RestAssured;
import io.restassured.http.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.given;

public class WithRestAssuredTest {

    final private static String url = "https://jsonplaceholder.typicode.com/posts";

    @Test (description = "TC01: Get response status code", priority = 1)
    public void testGetResponseStatusCode(){
        int statusCode = given().when().get(url).getStatusCode();
        System.out.println("The response status is " + statusCode);

        given().when().get(url).then().assertThat().statusCode(200);
    }

    @Test (description = "TC02: Get response time", priority = 2)
    public static void testGetResponseTime(){
        System.out.println("The time taken to fetch the response " + given().when().get(url)
                .timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
    }

    @Test (description = "TC03: Get headers details", priority = 3)
    public void testIteratingOverHeaders() {
        RestAssured.baseURI = url;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();

        Headers allHeaders = response.headers();
        for (Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
    }

    @Test (description = "TC04: Get body details", priority = 4)
    public void testGetBodyDetails() {
        RestAssured.baseURI = url;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET);

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("quia"));
        System.out.println("Response Body is =>  " + responseBody);
    }
}