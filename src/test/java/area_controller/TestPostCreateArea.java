package area_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;

public class TestPostCreateArea extends SuiteTest {

    @Test
    @DisplayName("POST Create Area status = 200")
    public void postCreateArea_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + AreaName + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"," +
                        "\"anchorId\":" + "\"" + AreaId + "\"," +
                        "\"position\":" + "\"" + "AFTER" + "\"" +
                        "}")
                .when()
                .post(EndPoints.Area)
                .then()
                .statusCode(201)
                .and().body("projectId", equalTo(31));
    }

    @Test
    @DisplayName("POST Create Area status = 401")
    public void postCreateArea_status_401() {
        given()
                .spec(spec)
                .body("{" +
                        "\"name\":" + "\"" + AreaName + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "\"anchorId\":" + "\"" + AreaId + "\"" +
                        "\"position\":" + "\"" + "AFTER" + "\"" +
                        "}")
                .when()
                .post(EndPoints.Area)
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("POST Create Area status = 404")
    public void postCreateArea_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + AreaName + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "\"anchorId\":" + "\"" + AreaId + "\"" +
                        "\"position\":" + "\"" + "AFTER" + "\"" +
                        "}")
                .when()
                .post("/api/projectts/" + Project_id + "/areas")
                .then()
                .statusCode(404);
    }

    @Test
    @DisplayName("POST Negative test 1 status = 400")
    public void postNegativeTest1_status400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"checksum\":" + "\"" + Checksum + "\"," +
                        "\"anchorId\":" + "\"" + AreaId + "\"," +
                        "\"position\":" + "\"" + "AFTER" + "\"" +
                        "}")
                .when()
                .post(EndPoints.Area)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative test 2 status = 400")
    public void postNegativeTest2_status400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + AreaName + "\"," +
                        "\"anchorId\":" + "\"" + AreaId + "\"," +
                        "\"position\":" + "\"" + "AFTER" + "\"" +
                        "}")
                .when()
                .post(EndPoints.Area)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative test 3 status = 400")
    public void postNegativeTest3_status400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + AreaName + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"," +
                        "\"anchorId\":" + "\"" + "QATest123" + "\"," +
                        "\"position\":" + "\"" + "AFTER" + "\"" +
                        "}")
                .when()
                .post(EndPoints.Area)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative test 4 status = 400")
    public void postNegativeTest4_status400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + AreaName + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"," +
                        "\"anchorId\":" + "\"" + AreaId + "\"," +
                        "\"position\":" + "\"" + "UP" + "\"" +
                        "}")
                .when()
                .post(EndPoints.Area)
                .then()
                .statusCode(400);
    }
}
