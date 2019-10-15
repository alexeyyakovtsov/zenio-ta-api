package story_controller;

import TestSuite.EndPoints;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestGetAllStories {

    @Test
    public void getAllStories_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get(EndPoints.AllStories)
                .then()
                .statusCode(200);
    }

    @Test
    public void getAllStories_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.AllStories)
                .then()
                .statusCode(401);
    }

    @Test
    public void getAllStories_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/projects/" + Project_id + "/storiess")
                .then()
                .statusCode(404);
    }
}
