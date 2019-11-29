package minor_release_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

public class TestPostCreateMinorRelease extends SuiteTest {

    @Test
    @DisplayName("POST Create Minor Release status = 200")
    public void postCreateMinorRelease_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + fake_name + "\"," +
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
    @DisplayName("POST Create Minor Release status = 401")
    public void postCreateMinorRelease_status_401() {
        given()
                .spec(spec)
                .body("{" +
                        "\"name\":" + "\"" + fake_name + "\"," +
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
    @DisplayName("POST Create Minor Release status = 404")
    public void postCreateMinorRelease_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + fake_name + "\"," +
                        "\"activityId\":" + "\"" + ActivityId + "\"," +
                        "\"majorReleaseId\":" + "\"" + MajorRelease + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .post("/api/projects/" + Project_id + "/releases/minorr")
                .then()
                .statusCode(404);
    }

    @Test
    @DisplayName("POST Negative test 1 status = 400")
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
                .post(EndPoints.CreateMinorRelease)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative test 2 status = 400")
    public void postNegativeTest2_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + fake_name + "\"," +
                        "\"activityId\":" + "\"" + ActivityId + "\"," +
                        "\"majorReleaseId\":" + "\"" + MajorRelease + "\"," +
                        "}")
                .when()
                .post(EndPoints.CreateMinorRelease)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative test 3 status = 400")
    public void postNegativeTest3_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + fake_name + "\"," +
                        "\"activityId\":" + "\"" + "QATest123" + "\"," +
                        "\"majorReleaseId\":" + "\"" + MajorRelease + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .post(EndPoints.CreateMinorRelease)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative test 3 status = 400")
    public void postNegativeTest4_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + fake_name + "\"," +
                        "\"activityId\":" + "\"" + ActivityId + "\"," +
                        "\"majorReleaseId\":" + "\"" + "QATest123" + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .post(EndPoints.CreateMinorRelease)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative test 5 status = 400")
    public void postNegativeTest5_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + fake_name + "\"," +
                        "\"activityId\":" + "\"" + ActivityId + "\"," +
                        "\"majorReleaseId\":" + "\"" + "QATest123" + "\"," +
                        "\"anchorId\":" + "\"" + "QATest123" + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .post(EndPoints.CreateMinorRelease)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative test 6 status = 400")
    public void postNegativeTest6_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + fake_name + "\"," +
                        "\"activityId\":" + "\"" + ActivityId + "\"," +
                        "\"majorReleaseId\":" + "\"" + MajorRelease + "\"," +
                        "\"position\":" + "\"" + "UP" + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .post(EndPoints.CreateMinorRelease)
                .then()
                .statusCode(400);
    }
}
