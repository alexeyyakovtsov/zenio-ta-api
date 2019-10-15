package project_controller;

import TestSuite.EndPoints;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestGetProjectsId {

    @Test
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
    public void getProjectId_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.GetProjectId)
                .then()
                .statusCode(401);
    }

    @Test
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
