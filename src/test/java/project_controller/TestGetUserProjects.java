package project_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static TestSuite.SuiteTest.*;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TestGetUserProjects {

    @Test
    public void getUserProjects_status_200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/projects")
                .then()
                .statusCode(200)
                .and()
                .body(matchesJsonSchemaInClasspath("getUserProjects.json"));
    }

    @Test
    public void getUserProjects_status_401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/projects")
                .then()
                .statusCode(401);
    }

    @Test
    public void getUserProjects_status_404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/projectss")
                .then()
                .statusCode(404);
    }
}
