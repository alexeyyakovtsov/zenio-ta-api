package area_controller;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static TestSuite.SuiteTest.*;

public class TestGetAreaId {

    @Test
    public void getAreaId_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/projects/" + Project_id + "/areas/" + AreaId)
                .then()
                .statusCode(200)
                .and().body("id", equalTo(AreaId))
                .and().body("projectId", equalTo(Project_id))
                .and().body("activityIds", hasItems(1639, 1643, 1053));
    }

    @Test
    public void getAreaId_status_401() {
        given()
                .spec(spec)
                .when()
                .get("/api/projects/" + Project_id + "/areas/" + AreaId)
                .then()
                .statusCode(401);
    }

    @Test
    public void getAreaId_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/projects/" + Project_id + "/areaas/" + AreaId)
                .then()
                .statusCode(404);
    }
}
