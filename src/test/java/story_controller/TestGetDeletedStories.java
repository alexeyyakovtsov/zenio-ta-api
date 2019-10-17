package story_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.hasItems;
import static io.restassured.RestAssured.given;

public class TestGetDeletedStories extends SuiteTest {

    @Test
    @DisplayName("GET Deleted Stories status = 200")
    public void getDeletedStories_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get(EndPoints.GetDeletedStories)
                .then()
                .statusCode(200)
                .and().body("stories.id", hasItems(15975, 15976));
    }

    @Test
    @DisplayName("GET Deleted Stories status = 401")
    public void getDeletedStories_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.GetDeletedStories)
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
