package minor_release_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

public class TestPostCreateMinorRelease extends SuiteTest {

    @Test
    public void postCreateMinorRelease_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + MinorReleaseName + "\"," +
                        "\"activityId\":" + "\"" + ActivityId + "\"," +
                        "\"majorReleaseId\":" + "\"" + MajorRelease + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .post(EndPoints.CreateMinorRelease)
                .then()
                .statusCode(201)
                .and().body("projectId", equalTo(Project_id))
                .and().body("majorReleaseId", equalTo(MajorRelease));
    }

    @Test
    public void postCreateMinorRelease_status_401() {
        given()
                .spec(spec)
                .body("{" +
                        "\"name\":" + "\"" + MinorReleaseName + "\"," +
                        "\"activityId\":" + "\"" + ActivityId + "\"," +
                        "\"majorReleaseId\":" + "\"" + MajorRelease + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .post(EndPoints.CreateMinorRelease)
                .then()
                .statusCode(401);
    }

    @Test
    public void postCreateMinorRelease_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + MinorReleaseName + "\"," +
                        "\"activityId\":" + "\"" + ActivityId + "\"," +
                        "\"majorReleaseId\":" + "\"" + MajorRelease + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .post("/api/projects/" + Project_id + "/releases/minorr")
                .then()
                .statusCode(404);
    }
}
