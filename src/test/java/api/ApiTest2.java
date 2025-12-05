package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTest2 {

    public void ShowJson(Response response){

        String jsonString = response.getBody().asString();

        // Afficher dans la console
        System.out.println(jsonString);

    }

    @Test
    public void testGetUsers() {
        RestAssured.baseURI = "https://demoqa.com";

        given()
                .when()
                .get("/BookStore/v1/Books")
                .then()
                .statusCode(200)
                .body("books", is(not(empty())))
                .body("books[0].isbn", notNullValue());
    }

    @Test
    public void testGetInfoBook() {
        RestAssured.baseURI = "https://demoqa.com";

        Response response =
                given()
                        .when()
                        .get("/BookStore/v1/Books");

        ShowJson(response);

        response
                .then()
                .statusCode(200)
                .body("books.title", hasItem("Speaking JavaScript"))
                //.body("books.find { it.title == 'Speaking JavaScript' }.description", not(emptyOrNullString()));
                .body("books.find { tmp -> tmp.title == 'Speaking JavaScript' }.description", not(emptyOrNullString()));
    }
}

