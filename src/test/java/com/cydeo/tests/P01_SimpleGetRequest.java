package com.cydeo.tests;

import com.cydeo.util.FakeStoreTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P01_SimpleGetRequest extends FakeStoreTestBase {


    /*

    DAY 2 -> RESPONSE.PATH VS JSONPATH METHODS
             PATH PARAM VS QUERY PARAM

    DAY 3 -> POJO
             DESERIALIZATION -> GET
             SERIALIZATION -> POST -> DELETE

    DAY 4 -> AUTHORIZATION
             PREPARATION FOR CUCUMBER

    DAY 5 -> SHARE READY REPO.
             - LOGS -> LOG4J2
             - E2E -> UI - DB - API
             - API

   POSTMAN AUTOMATION -> JAMAL RECORDINGS



     */

    /*
     * 1- Given accept type is Json
     * 2- When user sends GET request to api/v1/products
     * 3- Verify followings
     * - Status code should be 200
     * - Content Type is application/json; charset=utf-8
     * - Print response
     * - Headers
     * - Print content-length header
     * - Verify response has Date
     */

    @Test
   public void task1() {

        Response response = RestAssured.given().log().uri()
                .accept(ContentType.JSON)
                //.baseUri("https://api.escuelajs.co")
                .when().get("/api/v1/products");

        // response.prettyPrint();


        System.out.println("-------- STATUS CODE  --------");
        int statusCode = response.statusCode();
        // no difference response.getStatusCode();
        System.out.println(statusCode);
        Assertions.assertEquals(200,statusCode);

        System.out.println("-------- CONTENT TYPE --------");
        String contentType = response.contentType();
        System.out.println("contentType = " + contentType);
        Assertions.assertEquals("application/json; charset=utf-8",contentType);


        System.out.println("-------- HEADERS --------");
        System.out.println("response.getHeaders() = " + response.getHeaders());
        System.out.println("response.headers() = " + response.headers());

        System.out.println("-------- CONTENT-LENGTH  --------");
        System.out.println("response.getHeader(\"Content-Length\") = " + response.getHeader("Content-Length"));
        System.out.println("response.header(\"Content-Lenght\") = " + response.header("Content-Length"));

        System.out.println("-------- DATE --------");
        boolean hasDate = response.getHeaders().hasHeaderWithName("Date");
        Assertions.assertTrue(hasDate);


    }

}
