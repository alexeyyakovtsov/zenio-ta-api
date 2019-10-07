package story_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestPutUpdateStory {

    @Test
    public void putUpdateStory_status_200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"id\":" + StoryId + "," +
                        "\"name\":" + "\"" + StoryName + "\"," +
                        "\"description\":" + "\"" + Description + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"," +
                        "\"activityIds\":" + "[" + ActivityId + "]" +
                        "}")
                .when()
                .put("/api/projects/" + Project_id + "/stories")
                .then()
                .statusCode(200)
                .and().body("id", equalTo(StoryId))
                .and().body("projectId", equalTo(Project_id))
                .and().body("majorReleaseId", equalTo(MajorRelease));
    }

    @Test
    public void putUpdateStory_status_401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"id\":" + "\"" + Project_update_id + "\"," +
                        "\"name\":" + "\"" + StoryName + "\"," +
                        "\"description\":" + "\"" + Description + "\"" +
                        "}")
                .when()
                .put("/api/projects/" + Project_id + "/stories")
                .then()
                .statusCode(401);
    }

    @Test
    public void putUpdateStory_status_404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"id\":" + "\"" + Project_update_id + "\"," +
                        "\"name\":" + "\"" + StoryName + "\"," +
                        "\"description\":" + "\"" + Description + "\"" +
                        "}")
                .when()
                .put("/api/projects/" + Project_id + "/storiess")
                .then()
                .statusCode(404);
    }
}
