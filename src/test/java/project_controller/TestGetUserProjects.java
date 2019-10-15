package project_controller;

import org.junit.Test;

import static TestSuite.SuiteTest.*;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TestGetUserProjects {

    @Test
    public void getUserProjects_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
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
                .spec(spec)
                .when()
                .get("/api/projects")
                .then()
                .statusCode(401);
    }

    @Test
    public void getUserProjects_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/projectss")
                .then()
                .statusCode(404);
    }
}
