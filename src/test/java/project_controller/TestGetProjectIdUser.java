package project_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestGetProjectIdUser {

    @Test
    public void getProjectIdUser_status200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/projects/" +  Project_id + "/users")
                .then()
                .statusCode(200)
                .and().body(matchesJsonSchemaInClasspath("getProjectsIdUsers.json"));
    }

    @Test
    public void getProjectIdUser_status401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/projects/" +  Project_id + "/users")
                .then()
                .statusCode(401);
    }

    @Test
    public void getProjectIdUser_status404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/projectss/" +  Project_id + "/users")
                .then()
                .statusCode(404);
    }
}
