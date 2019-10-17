package project_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Ignore;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

public class TestDeleteProjectId extends SuiteTest {

    @Ignore
    @Test
    @DisplayName("DELETE Project status = 200")
    public void deleteProjectId_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .delete(EndPoints.DeleteProjectId)
                .then()
                .statusCode(204);
    }

    @Ignore
    @Test
    @DisplayName("DELETE Project status = 401")
    public void deleteProjectId_status_401() {
        given()
                .spec(spec)
                .when()
                .delete(EndPoints.DeleteProjectId)
                .then()
                .statusCode(401);
    }

    @Ignore
    @Test
    @DisplayName("DELETE Project status = 404")
    public void deleteProjectId_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .delete("/api/projectts" + Project_deleted_id)
                .then()
                .statusCode(404);
    }
}
