package activity_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestPutUpdateActivityId extends SuiteTest {

    @Test
    @DisplayName("PUT Update Activity status = 200")
    public void putUpdateActivity_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"areaId\":" + "\"" + AreaId + "\"," +
                        "\"name\":" + "\"" + ActivityName + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"," +
                        "\"description\":" + "\"" + "123" + "\"" +
                        "}")
                .when()
                .put(EndPoints.UpdateActivityId)
                .then()
                .statusCode(200)
                .and().body("id", equalTo(ActivityId))
                .and().body("description", equalTo("123"))
                .and().body("projectId", equalTo(Project_id));
    }

    @Test
    @DisplayName("PUT Update Activity status = 401")
    public void putUpdateActivity_status_401() {
        given()
                .spec(spec)
                .body("{" +
                        "\"name\":" + "\"" + ActivityName + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"," +
                        "\"description\":" + "\"" + "123" + "\"" +
                        "}")
                .when()
                .put(EndPoints.UpdateActivityId)
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("PUT Update Activity status = 404")
    public void putUpdateActivity_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + ActivityName + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"," +
                        "\"description\":" + "\"" + "123" + "\"" +
                        "}")
                .when()
                .put("/api/projects/" + Project_id + "/activitiess")
                .then()
                .statusCode(404);
    }
}
