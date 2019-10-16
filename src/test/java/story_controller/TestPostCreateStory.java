package story_controller;

import TestSuite.EndPoints;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static TestSuite.SuiteTest.*;

public class TestPostCreateStory {

    @Test
    public void postCreateStory_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + ProjectName + "\"," +
                        "\"activityId\":" + "\"" + ActivityId + "\"," +
                        "\"majorReleaseId\":" + "\"" + MajorRelease + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .post(EndPoints.AllStories)
                .then()
                .statusCode(201)
                .and().body("projectId", equalTo(Project_id))
                .and().body("majorReleaseId", equalTo(MajorRelease));
    }

    @Test
    public void postCreateStory_status_401() {
        given()
                .spec(spec)
                .body("{" +
                        "\"name\":" + "\"" + ProjectName + "\"," +
                        "\"activityId\":" + "\"" + ActivityId + "\"," +
                        "\"majorReleaseId\":" + "\"" + MajorRelease + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .post(EndPoints.AllStories)
                .then()
                .statusCode(401);
    }

    @Test
    public void postCreateStory_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + ProjectName + "\"," +
                        "\"activityId\":" + "\"" + ActivityId + "\"," +
                        "\"majorReleaseId\":" + "\"" + MajorRelease + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .post("/api/projects/" + Project_id + "/storiess")
                .then()
                .statusCode(404);
    }
}
