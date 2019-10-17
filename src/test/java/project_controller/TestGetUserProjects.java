package project_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class TestGetUserProjects extends SuiteTest {

    @Test
    @DisplayName("GET User Projects status = 200")
    public void getUserProjects_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get(EndPoints.UserProjects)
                .then()
                .statusCode(200);
    }

    @Test
    public void getUserProjects_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.UserProjects)
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
