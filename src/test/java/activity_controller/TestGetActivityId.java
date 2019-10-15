package activity_controller;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static TestSuite.SuiteTest.*;

public class TestGetActivityId {

    @Test
    public void getActivityId_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/projects/" + Project_id + "/activities/" + ActivityId)
                .then()
                .statusCode(200)
                .and().body("id", equalTo(ActivityId))
                .and().body("areaId", equalTo(AreaId))
                .and().body("projectId", equalTo(Project_id))
                .and().body("majorReleases.id", hasItems(2216, 2229));
    }

    @Test
    public void getActivityId_status_401() {
        given()
                .spec(spec)
                .when()
                .get("/api/projects/" + Project_id + "/activities/" + ActivityId)
                .then()
                .statusCode(401);
    }

    @Test
    public void getActivityId_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/projectss/" + Project_id + "/activities/" + ActivityId)
                .then()
                .statusCode(404);
    }
}
