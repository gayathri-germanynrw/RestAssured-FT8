package com.cydeo.tests;

import com.cydeo.util.FormulaTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

public class P04_DeserializationPOJO extends FormulaTestBase {

    /*
        - ERGAST API ( Formula API )
        - When user send request /status.json
        - Then verify status code is 200
        - And content type is application/json; charset=utf-8
        - And total is 137
        - And limit is 30
        - And each status has statusId
     */

    /*

    DESERIALIZATION

      RESPONSE --> JSON (Javascript Object Notation)

      let employee={
                        "name":"Mike",
                        "age":34,
                        "gender":"Male"
                    }

      public class Employee{

       private String name;
       private int age;
       private String gender;

      }

      JSON --> TO --> JAVA
      XML  --> TO --> JAVA

      How we will do that ?

      1- Get All JSON --> JAVA Data Structure --> Map,List etc.

      2- Get All JSON --> JAVA Custom Classes --> POJO (Plain Old Java Object)

     Do we need to have any library for De-serialization/ Serialization ?

      - Yes we need to have one databind || objectMapper
         - Gson
         - Jackson
         - Yasson etc.

         <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.15.1</version>
        </dependency>

     */

    @Test
    public void task1() {

        JsonPath jp = RestAssured.when().get("/status.json")
                .then().statusCode(200)
                .contentType(ContentType.JSON.withCharset("utf-8"))
                .extract().jsonPath();


    }
}
