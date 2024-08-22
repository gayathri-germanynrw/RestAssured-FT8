package com.cydeo.tests;

import com.cydeo.util.APIUtil;
import com.cydeo.util.FakeStoreTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P02_PathParam extends FakeStoreTestBase {

    /*
    OBJECT
    JSON --> {
                "name":"Apple",
                "price":"10"
              }

              [
                  {
                    "id":1,
                    "name":"Apple",
                    "price":"10"
                  },
                  {
                   "id":2,
                    "name":"Orange",
                    "price":"5"
                  }

               ]

    JAVA --> new Product();

     PATH PARAM

       - It is a part of URL to point single set of data
       - Returns single data from list of resources
          // email / ssn / id (user,customer,product......)
       - Swagger -> api/v1/products/{id}
       - Postman -> :id
                 -> Path Variable
                 -> id - 4

     */


    /*
     * 1- Given accept type is Json
     * 2- Path Parameters value is
     * - id —> 144
     * 3- When user sends GET request to api/v1/products/{id}
     * 4- Verify followings
     * - Status code should be 200
     * - Content Type is application/json; charset=utf-8
     * - Print response
     * - id is 144
     * - Title is "Laptop"
     * - Category name is "Electronics"
     */

    @Test
    public void task1() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id", 144)
                .when().get("/api/v1/products/{id}");

        response.prettyPrint();


        //     * - Status code should be 200
        Assertions.assertEquals(200,response.statusCode());

        //     * - Content Type is application/json; charset=utf-8
        Assertions.assertEquals(ContentType.JSON.withCharset("utf-8"),response.contentType());

        //     * - id is 144
        int id = response.path("id");
        System.out.println("id = " + id);
        Assertions.assertEquals(144,id);

        //     * - Title is "Laptop"
        Assertions.assertEquals("Laptop",response.path("title"));

        //     * - Category name is "Electronics"
        Assertions.assertEquals("Electronics",response.path("category.name"));

    }



    @Test
    public void task2() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id", 144)
                .when().get("/api/v1/products/{id}");

        response.prettyPrint();


        // Init JSONPATH OBJECT
        JsonPath jp = response.jsonPath();

        //     * - Status code should be 200
        Assertions.assertEquals(200,response.statusCode());

        //     * - Content Type is application/json; charset=utf-8
        Assertions.assertEquals(ContentType.JSON.withCharset("utf-8"),response.contentType());

        //     * - id is 144
        Assertions.assertEquals(144,jp.getInt("id"));

        //     * - Title is "Laptop"
        Assertions.assertEquals("Laptop",jp.getString("title"));

        //     * - Category name is "Electronics"
        Assertions.assertEquals("Electronics",jp.getString("category.name"));

    }

    @Test
    public void task3() {
        Response response = APIUtil.getResponse("products", 144);

        // Init JSONPATH OBJECT
        JsonPath jp = response.jsonPath();

        //     * - Status code should be 200
        Assertions.assertEquals(200,response.statusCode());

        //     * - Content Type is application/json; charset=utf-8
        Assertions.assertEquals(ContentType.JSON.withCharset("utf-8"),response.contentType());

        //     * - id is 144
        Assertions.assertEquals(144,jp.getInt("id"));

        //     * - Title is "Laptop"
        Assertions.assertEquals("Laptop",jp.getString("title"));

        //     * - Category name is "Electronics"
        Assertions.assertEquals("Electronics",jp.getString("category.name"));

    }

    @Test
    public void task4() {

        Response response = APIUtil.getResponse("categories", 2);

        response.prettyPrint();
    }
}
