package area_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.Description;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;

public class TestGetAreaId extends SuiteTest {

    @Test
    @Description("Get Area ID status = 200")
    public void getAreaId_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get(EndPoints.GetAreaId)
                .then()
                .statusCode(200)
                .and().body("id", equalTo(AreaId))
                .and().body("projectId", equalTo(Project_id))
                .and().body("activityIds", hasItems(1639, 1643, 1053));
    }

    @Test
    @Description("Get Area ID status = 401")
    public void getAreaId_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.GetAreaId)
                .then()
                .statusCode(401);
    }

    @Test
    @Description("Get Area ID status = 404")
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
