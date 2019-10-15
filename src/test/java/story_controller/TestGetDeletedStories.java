package story_controller;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestGetDeletedStories {

    @Test
    public void getDeletedStories_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/projects/" + Project_id + "/stories/deleted")
                .then()
                .statusCode(200)
                .and().body("stories.id", hasItems(15975, 15976));
    }

    @Test
    public void getDeletedStories_status_401() {
        given()
                .spec(spec)
                .when()
                .get("/api/projects/" + Project_id + "/stories/deleted")
                .then()
                .statusCode(401);
    }

  /*  @Test
    public void getDeletedStories_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/projects/" + Project_id + "/stories/deletedd")
                .then()
                .statusCode(404);
    }*/
}
