package com.cydeo.tests;

import com.cydeo.util.FakeStoreTestBase;
import org.junit.jupiter.api.Test;

public class P03_QueryParam extends FakeStoreTestBase {
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
     * - Get product ids
     * - Get all category names
     */

    @Test
    public void task1() {

    }
}
