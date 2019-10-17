package project_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static parameters.Configurations.*;

public class TestGetProjectIdUser extends SuiteTest {

    @Test
    @DisplayName("GET Team Projects status = 200")
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
    @DisplayName("GET Team Projects status = 401")
    public void getProjectIdUser_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.GetProjectIdUser)
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("GET Team Projects status = 404")
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
