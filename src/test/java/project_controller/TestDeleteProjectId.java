package project_controller;

import TestSuite.EndPoints;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestDeleteProjectId {

    @Test
    public void deleteProjectId_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .delete(EndPoints.DeleteProjectId)
                .then()
                .statusCode(204);
    }

    @Test
    public void deleteProjectId_status_401() {
        given()
                .spec(spec)
                .when()
                .delete(EndPoints.DeleteProjectId)
                .then()
                .statusCode(401);
    }

    @Test
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
