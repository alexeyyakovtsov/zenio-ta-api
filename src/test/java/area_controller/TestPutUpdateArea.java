package area_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

public class TestPutUpdateArea extends SuiteTest {

    @Test
    @DisplayName("PUT Update Area status = 200")
    public void putUpdateArea_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + fake_name + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"," +
                        "\"description\":" + "\"" + "123" + "\"" +
                        "}")
                .when()
                .put(EndPoints.GetAreaId)
                .then()
                .statusCode(200)
                .and().body("id", equalTo(AreaId))
                .and().body("projectId", equalTo(Project_id))
                .and().body("description", equalTo("123"));
    }

    @Test
    @DisplayName("PUT Update Area status = 401")
    public void putUpdateArea_status_401() {
        given()
                .spec(spec)
                .body("{" +
                        "\"name\":" + "\"" + fake_name + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"," +
                        "\"description\":" + "\"" + "123" + "\"" +
                        "}")
                .when()
                .put(EndPoints.GetAreaId)
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("PUT Update Area status = 404")
    public void putUpdateArea_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + fake_name + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"," +
                        "\"description\":" + "\"" + "123" + "\"" +
                        "}")
                .when()
                .put("/api/projectts/" + Project_id + "/areas")
                .then()
                .statusCode(404);
    }
}
