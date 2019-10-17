package story_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.hasItems;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestGetStoryId extends SuiteTest {

    @Test
    public void getStoryId_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get(EndPoints.GetStoryId)
                .then()
                .statusCode(200)
                .and().body("id", equalTo(StoryId))
                .and().body("projectId", equalTo(Project_id))
                .and().body("majorReleaseId", equalTo(MajorRelease))
                .and().body("activityIds", hasItems(1053));
    }

    @Test
    public void getStoryId_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.GetStoryId)
                .then()
                .statusCode(401);
    }

    @Test
    public void getStoryId_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/projects/" + Project_id + "/storiess/" + StoryId)
                .then()
                .statusCode(404);
    }
}
