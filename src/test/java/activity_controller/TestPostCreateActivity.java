package activity_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

public class TestPostCreateActivity extends SuiteTest {

    @Test
    @DisplayName("POST Create Activity status = 200")
     public void postCreateActivity_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + ActivityName + "\"," +
                        "\"areaId\":" + "\"" + AreaId + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .post(EndPoints.Activity)
                .then()
                .statusCode(201)
                .and().body("areaId", equalTo(AreaId))
                .and().body("projectId", equalTo(Project_id));
    }

    @Test
    @DisplayName("POST Create Activity status = 401")
    public void postCreateActivity_status_401() {
        given()
                .spec(spec)
                .body("{" +
                        "\"name\":" + "\"" + ActivityName + "\"," +
                        "\"areaId\":" + "\"" + AreaId + "\"" +
                        "}")
                .when()
                .post(EndPoints.Activity)
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("POST Create Activity status = 404")
    public void postCreateActivity_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + ActivityName + "\"," +
                        "\"areaId\":" + "\"" + AreaId + "\"" +
                        "}")
                .when()
                .post("/api/projectss/" + Project_id + "/activities")
                .then()
                .statusCode(404);
    }
}
