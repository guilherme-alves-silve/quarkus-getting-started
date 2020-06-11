package br.com.guilhermealvessilve.study.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void testGetBooks() {
        given()
                .when().get("/book")
                .then()
                .statusCode(200)
                .body(is(",[The Freelancer's bible]"));
    }

    @Test
    public void testAddBook() {
        given()
                .when().body("Other book")
                .post("/book")
                .then()
                .statusCode(200)
                .body(is("Other book"));
    }

    @Test
    public void testUpdateBook() {
        given()
                .when().body("The Simple Freelancer")
                .put("/book/0")
                .then()
                .statusCode(200)
                .body(is("The Simple Freelancer"));
    }

    @Test
    public void testDeleteBook() {
        given()
                .when()
                .delete("/book/0")
                .then()
                .statusCode(200)
                .body(is("The Simple Freelancer"));
    }
}
