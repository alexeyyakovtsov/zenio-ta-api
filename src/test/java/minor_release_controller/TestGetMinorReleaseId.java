package minor_release_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

public class TestGetMinorReleaseId extends SuiteTest {

    @Test
    @DisplayName("GET Minor Release status = 200")
    public void getMinorRelease_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get(EndPoints.GetMinorReleaseId)
                .then()
                .statusCode(200)
                .and().body("id", equalTo(MinorRelease))
                .and().body("projectId", equalTo(Project_id))
                .and().body("majorReleaseId", equalTo(MajorRelease))
                .and().body("activityIds", hasItems(1643));
    }

    @Test
    @DisplayName("GET Minor Release status = 401")
    public void getMinorRelease_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.GetMinorReleaseId)
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("GET Minor Release status = 404")
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
