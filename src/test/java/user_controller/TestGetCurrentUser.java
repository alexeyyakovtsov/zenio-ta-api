package user_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestGetCurrentUser {

    @Test
    public void getCurrentUser_200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/users/me")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("getCurrentUser.json"))
                .and().body("username", equalTo("zenio"))
                .and().body("email", equalTo("zenio@zensoft.io"))
                .and().body("active", equalTo(true))
                .and().body("enabled", equalTo(true))
                .and().body("roles", hasItems("ADMIN"));
    }

    @Test
    public void getCurrentUser_status401() {
        given()
                .baseUri(URL_Dev)
                .when()
                .get("/api/users/me")
                .then()
                .statusCode(401);
    }

    @Test
    public void getCurrentUser_status404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/users/meу")
                .then()
                .statusCode(404);
    }
}
