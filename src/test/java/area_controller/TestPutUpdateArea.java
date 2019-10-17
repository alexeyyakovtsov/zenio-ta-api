package area_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

public class TestPutUpdateArea extends SuiteTest {

    @Test
    public void putUpdateArea_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + AreaName + "\"," +
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
    public void putUpdateArea_status_401() {
        given()
                .spec(spec)
                .body("{" +
                        "\"name\":" + "\"" + AreaName + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"," +
                        "\"description\":" + "\"" + "123" + "\"" +
                        "}")
                .when()
                .put(EndPoints.GetAreaId)
                .then()
                .statusCode(401);
    }

    @Test
    public void putUpdateArea_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + AreaName + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"," +
                        "\"description\":" + "\"" + "123" + "\"" +
                        "}")
                .when()
                .put("/api/projectts/" + Project_id + "/areas")
                .then()
                .statusCode(404);
    }
}
