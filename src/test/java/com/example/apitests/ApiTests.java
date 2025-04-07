package com.example.apitests;  // Use the correct package based on your project structure

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class ApiTests {

    // Setup method to configure the base URI for the Rest Assured API tests
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/api";  // Set base URI for API requests
    }

    // Test 1: Verify GET request to /users?page=2 returns status code 200 and page = 2
    @Test
    public void testGetUsers() {
        Response response = RestAssured.get("/users?page=2");

        // Assert that the status code is 200
        Assert.assertEquals(response.getStatusCode(), 200);

        // Assert that the page number in the response is 2
        Assert.assertEquals(response.jsonPath().getInt("page"), 2);
    }

    // Test 2: Verify GET request to /users/2 returns status code 200, id = 2, first_name = "Janet"
    @Test
    public void testGetUserById() {
        Response response = RestAssured.get("/users/2");

        // Assert that the status code is 200
        Assert.assertEquals(response.getStatusCode(), 200);

        // Assert that the id is 2 and first_name is "Janet"
        Assert.assertEquals(response.jsonPath().getInt("data.id"), 2);
        Assert.assertEquals(response.jsonPath().getString("data.first_name"), "Janet");
    }

    // Test 3: Verify POST request to /users creates a new user with the correct name and job
    @Test
    public void testCreateUser() {
        String requestBody = "{ \"name\": \"John\", \"job\": \"Developer\" }";

        Response response = RestAssured.given()
                                       .header("Content-Type", "application/json")
                                       .body(requestBody)
                                       .post("/users");

        // Assert that the status code is 201
        Assert.assertEquals(response.getStatusCode(), 201);

        // Assert that the response contains the correct name and job
        Assert.assertEquals(response.jsonPath().getString("name"), "John");
        Assert.assertEquals(response.jsonPath().getString("job"), "Developer");
    }

    // Test 4: Verify PUT request to /users/2 updates the user with updated name and job
    @Test
    public void testUpdateUser() {
        String requestBody = "{ \"name\": \"John\", \"job\": \"Senior Developer\" }";

        Response response = RestAssured.given()
                                       .header("Content-Type", "application/json")
                                       .body(requestBody)
                                       .put("/users/2");

        // Assert that the status code is 200
        Assert.assertEquals(response.getStatusCode(), 200);

        // Assert that the response contains the updated name and job
        Assert.assertEquals(response.jsonPath().getString("name"), "John");
        Assert.assertEquals(response.jsonPath().getString("job"), "Senior Developer");
    }

    // Test 5: Verify DELETE request to /users/2 returns status code 204
    @Test
    public void testDeleteUser() {
        Response response = RestAssured.delete("/users/2");

        // Assert that the status code is 204 (No Content)
        Assert.assertEquals(response.getStatusCode(), 204);
    }
}
