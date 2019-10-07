package user_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static TestSuite.SuiteTest.*;

public class TestGetAllUsers {

    @Test
    public void getAllUsers_status_200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get( "/api/users")
                .then()
                .statusCode(200)
                .and()
                .body(matchesJsonSchemaInClasspath("getAllUsers.json"));
    }

    @Test
    public void getAllUsers_status_401() {
        given()
                .baseUri(URL_Dev)
                .when()
                .get("/api/users")
                .then()
                .statusCode(401);
    }

    @Test
    public void getAllUsers_status_404(){
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/us1eers")
                .then()
                .statusCode(404);
    }
}
