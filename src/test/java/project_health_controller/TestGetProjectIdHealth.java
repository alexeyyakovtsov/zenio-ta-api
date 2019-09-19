package project_health_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static TestSuite.SuiteTest.*;

public class TestGetProjectIdHealth {

    @Test
    public void getProjectIdHealth_status200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/projects/" + Project_id + "/health")
                .then()
                .statusCode(200)
                .and().body("id", equalTo(Project_id))
                .and().body("name", equalTo("Empty"))
                .and().body("membersCount", equalTo(2))
                .and().body("wipStoriesCount", equalTo(0));
    }

    @Test
    public void getProjectIdHealth_status401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/projects/" + Project_id + "/health")
                .then()
                .statusCode(401);
    }

    @Test
    public void getProjectIdHealth_status404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/projectts/" + Project_id + "/health")
                .then()
                .statusCode(404);
    }
}
