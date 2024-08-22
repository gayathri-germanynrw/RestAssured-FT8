package com.cydeo.tests;

import org.junit.jupiter.api.Test;

public class P02_PathParam {

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

    }
}
