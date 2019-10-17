package activity_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;

public class TestGetActivityId extends SuiteTest {

    @Test
    @DisplayName("GET Activity status = 200")
    public void getActivityId_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get(EndPoints.GetActivityId)
                .then()
                .statusCode(200)
                .and().body("id", equalTo(ActivityId))
                .and().body("areaId", equalTo(AreaId))
                .and().body("projectId", equalTo(Project_id));
    }

    @Test
    @DisplayName("GET Activity status = 401")
    public void getActivityId_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.GetActivityId)
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("GET Activity status = 404")
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
