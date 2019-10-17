package story_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

public class TestPutUpdateStory extends SuiteTest {

    @Test
    public void putUpdateStory_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + StoryName + "\"," +
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
    public void putUpdateStory_status_401() {
        given()
                .spec(spec)
                .body("{" +
                        "\"name\":" + "\"" + StoryName + "\"," +
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
    public void putUpdateStory_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + StoryName + "\"," +
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
