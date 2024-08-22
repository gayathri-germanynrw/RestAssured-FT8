package com.cydeo.tests;

import com.cydeo.util.FakeStoreTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P03_QueryParam extends FakeStoreTestBase {

    /*
    QUERY PARAM
      - It is not part of URL
      - It is for filtering data based on provided
         Key and Value
      - It starts after ?

      /api/v1/products
      ? -> end of URL
      limit=10 -> QueryParam
      &
      offset=0 -> QueryParam
     */



    /*
     * 1- Given accept type is Json
     * 2- Query Parameters value is
     * - limit —> 10
     * - offset —> 0
     * 3- When user sends GET request to /products
     * 4- Verify followings
     * - Status code should be 200
     * - Content Type is application/json; charset=utf-8
     * - Each product has id
     * - Each product has category id
     * - Get all product names
     * - Get all product ids
     * - Get all category names
     */

    @Test
    public void task1() {

        JsonPath jp = RestAssured.given().accept(ContentType.JSON)
                .queryParam("limit", 10)
                .queryParam("offset", 0)
                .when().get("/api/v1/products").
                then().statusCode(200)
                .contentType(ContentType.JSON.withCharset("utf-8"))
                .extract().jsonPath();

        System.out.println("---- GET ME FIRST ID ------");
        System.out.println("jp.getInt(\"[0].id\") = " + jp.getInt("[0].id"));
        System.out.println("jp.getInt(\"id[0]\") = " + jp.getInt("id[0]"));

        System.out.println("---- GET ME LAST ID ------");
        System.out.println("jp.getInt(\"id[-1]\") = " + jp.getInt("id[-1]"));


        //     * - Each product has id
        //     * - Get all product ids
        List<Integer> allIDs = jp.getList("id");
        for (Integer eachID : allIDs) {
            System.out.println("eachID = " + eachID);
            Assertions.assertNotNull(eachID);
        }

        //     * - Each product has category id
        List<Integer> allCategoryIDs = jp.getList("category.id");
        for (Integer eachID : allCategoryIDs) {
            System.out.println("CategoryID = " + eachID);
            Assertions.assertNotNull(eachID);
        }

        //     * - Get all product title
        List<String> allTitles = jp.getList("title");
        for (String eachTitle : allTitles) {
            System.out.println("eachTitle = " + eachTitle);
        }

        //     * - Get all category names
        List<String> allCategoryNames = jp.getList("category.name");
        for (String eachCatName : allCategoryNames) {
            System.out.println("eachCatName = " + eachCatName);
        }

        // Get me all product title where product price more than 1000
        List<String> allProductOver1000 = jp.getList("findAll {it.price>1000}.title");
        System.out.println("allProductOver1000 = " + allProductOver1000);

    }
}
