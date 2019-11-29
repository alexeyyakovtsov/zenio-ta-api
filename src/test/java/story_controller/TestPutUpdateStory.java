package story_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

public class TestPutUpdateStory extends SuiteTest {

    @Test
    @DisplayName("PUT Update Story status = 200")
    public void putUpdateStory_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + fake_name + "\"," +
                        "\"description\":" + "\"" + Description + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"," +
                        "\"activityIds\":" + "[" + ActivityId + "]" +
                        "}")
                .when()
                .put(EndPoints.GetStoryId)
                .then()
                .statusCode(200)
                .and().body("id", equalTo(StoryId))
                .and().body("projectId", equalTo(Project_id))
                .and().body("majorReleaseId", equalTo(MajorRelease));
    }

    @Test
    @DisplayName("PUT Update Story status = 401")
    public void putUpdateStory_status_401() {
        given()
                .spec(spec)
                .body("{" +
                        "\"name\":" + "\"" + fake_name + "\"," +
                        "\"description\":" + "\"" + Description + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"," +
                        "\"activityIds\":" + "[" + ActivityId + "]" +
                        "}")
                .when()
                .put(EndPoints.GetStoryId)
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("PUT Update Story status = 404")
    public void putUpdateStory_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + fake_name + "\"," +
                        "\"description\":" + "\"" + Description + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"," +
                        "\"activityIds\":" + "[" + ActivityId + "]" +
                        "}")
                .when()
                .put("/api/projects/" + Project_id + "/storiess")
                .then()
                .statusCode(404);
    }
}
