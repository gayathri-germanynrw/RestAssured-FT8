package com.cydeo.util;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIUtil {

    // GET--> /api/v1/products/{id}
    // GET--> /api/v1/users/{id}
    // GET--> /api/v1/categories/{id}

    public static Response getResponse(String endpoint, int paramValue) {

    return       RestAssured.given().accept(ContentType.JSON)
                .pathParam("id", paramValue)

                .when().get("/api/v1/" + endpoint + "/{id}")

                .then().statusCode(200)
                .contentType(ContentType.JSON.withCharset("utf-8"))

                .extract().response();


    }
}
