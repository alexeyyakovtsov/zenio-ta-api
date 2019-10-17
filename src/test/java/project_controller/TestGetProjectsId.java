package project_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static parameters.Configurations.*;

public class TestGetProjectsId extends SuiteTest {

    @Test
    @DisplayName("GET User Project ID status = 200")
    public void getProjectId_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get(EndPoints.GetProjectId)
                .then()
                .statusCode(200)
                .and().body("id", equalTo(Project_id))
                .and().body("workspaceId", equalTo(4))
                .and().body("deleted", equalTo(false))
                .and().body("ownerId", equalTo(1));
    }

    @Test
    @DisplayName("GET User Project ID status = 401")
    public void getProjectId_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.GetProjectId)
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("GET User Project ID status = 404")
    public void getProjectId_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/projectss/" + Project_id)
                .then()
                .statusCode(404);
    }
}
