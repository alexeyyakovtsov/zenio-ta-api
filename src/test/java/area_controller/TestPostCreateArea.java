package area_controller;

import TestSuite.EndPoints;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static TestSuite.SuiteTest.*;

public class TestPostCreateArea {

    @Test
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
}
