package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class ApiTest {

    @Test
    public void testGetUsers() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        String jsonResponse = given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .extract()
                .asString();

        System.out.println(jsonResponse);
    }

    @Test
    public void testGetSingleUser() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response response =
                given()
                        .when()
                        .get("/users/1");

        response
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("username", not(emptyOrNullString()));
    }

    @Test
    public void testGetProducts() {
        RestAssured.baseURI = "https://fakestoreapi.com";

        String jsonResponse = given()
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0)) // Vérifie qu'on a au moins un produit
                .extract()
                .asString();

        System.out.println(jsonResponse);
    }

}
