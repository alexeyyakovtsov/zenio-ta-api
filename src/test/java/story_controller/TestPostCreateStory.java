package story_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;

public class TestPostCreateStory extends SuiteTest {

    @Test
    @DisplayName("POST Create Story status = 200")
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
    @DisplayName("POST Create Story status = 401")
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
    @DisplayName("POST Create Story status = 404")
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

    @Test
    @DisplayName("POST Negative Test 1 status = 400")
    public void postNegativeTest1_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"activityId\":" + "\"" + ActivityId + "\"," +
                        "\"majorReleaseId\":" + "\"" + MajorRelease + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .post(EndPoints.AllStories)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative Test 2 status = 400")
    public void postNegativeTest2_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + ProjectName + "\"," +
                        "\"activityId\":" + "\"" + ActivityId + "\"," +
                        "\"majorReleaseId\":" + "\"" + MajorRelease + "\"" +
                        "}")
                .when()
                .post(EndPoints.AllStories)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative Test 3 status = 400")
    public void postNegativeTest3_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + ProjectName + "\"," +
                        "\"activityId\":" + "\"" + "QATest123" + "\"," +
                        "\"majorReleaseId\":" + "\"" + MajorRelease + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .post(EndPoints.AllStories)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative Test 4 status = 400")
    public void postNegativeTest4_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + ProjectName + "\"," +
                        "\"activityId\":" + "\"" + ActivityId + "\"," +
                        "\"majorReleaseId\":" + "\"" + "QATest123" + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .post(EndPoints.AllStories)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative Test 5 status = 400")
    public void postNegativeTest5_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + ProjectName + "\"," +
                        "\"activityId\":" + "\"" + ActivityId + "\"," +
                        "\"majorReleaseId\":" + "\"" + MajorRelease + "\"," +
                        "\"anchorId\":" + "\"" + "QATest123" + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .post(EndPoints.AllStories)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative Test 6 status = 400")
    public void postNegativeTest6_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + ProjectName + "\"," +
                        "\"activityId\":" + "\"" + ActivityId + "\"," +
                        "\"majorReleaseId\":" + "\"" + MajorRelease + "\"," +
                        "\"position\":" + "\"" + "UP" + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .post(EndPoints.AllStories)
                .then()
                .statusCode(400);
    }
}
