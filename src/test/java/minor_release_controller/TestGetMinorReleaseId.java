package minor_release_controller;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestGetMinorReleaseId {

    @Test
    public void getMinorRelease_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/projects/" + Project_id + "/releases/minor/" + MinorRelease)
                .then()
                .statusCode(200)
                .and().body("id", equalTo(MinorRelease))
                .and().body("projectId", equalTo(Project_id))
                .and().body("majorReleaseId", equalTo(MajorRelease))
                .and().body("activityIds", hasItems(1643));
    }

    @Test
    public void getMinorRelease_status_401() {
        given()
                .spec(spec)
                .when()
                .get("/api/projects/" + Project_id + "/releases/minor/" + MinorRelease)
                .then()
                .statusCode(401);
    }

    @Test
    public void getMinorRelease_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/projects/" + Project_id + "/releases/minorr/" + MinorRelease)
                .then()
                .statusCode(404);
    }
}
