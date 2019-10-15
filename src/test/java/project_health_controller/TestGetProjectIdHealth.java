package project_health_controller;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static TestSuite.SuiteTest.*;

public class TestGetProjectIdHealth {

    @Test
    public void getProjectIdHealth_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/projects/" + Project_id + "/health")
                .then()
                .statusCode(200)
                .and().body("id", equalTo(Project_id))
                .and().body("name", equalTo("QA Test API"))
                .and().body("membersCount", equalTo(1))
                .and().body("wipStoriesCount", equalTo(0));
    }

    @Test
    public void getProjectIdHealth_status_401() {
        given()
                .spec(spec)
                .when()
                .get("/api/projects/" + Project_id + "/health")
                .then()
                .statusCode(401);
    }

    @Test
    public void getProjectIdHealth_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/projectts/" + Project_id + "/health")
                .then()
                .statusCode(404);
    }
}
