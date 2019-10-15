package project_controller;

import TestSuite.EndPoints;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestGetProjectIdUser {

    @Test
    public void getProjectIdUser_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get(EndPoints.GetProjectIdUser)
                .then()
                .statusCode(200)
                .and().body(matchesJsonSchemaInClasspath("getProjectsIdUsers.json"));
    }

    @Test
    public void getProjectIdUser_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.GetProjectIdUser)
                .then()
                .statusCode(401);
    }

    @Test
    public void getProjectIdUser_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/projectss/" +  Project_id + "/users")
                .then()
                .statusCode(404);
    }
}
