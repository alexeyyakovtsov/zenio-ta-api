package activity_controller;

import TestSuite.EndPoints;
import org.junit.Test;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static TestSuite.SuiteTest.*;

public class TestPutUpdateActivityId {

    @Test
    public void putUpdateActivity_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"id\":" + "\"" + ActivityId + "\"," +
                        "\"areaId\":" + "\"" + AreaId + "\"," +
                        "\"name\":" + "\"" + ActivityName + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"," +
                        "\"description\":" + "\"" + "123" + "\"" +
                        "}")
                .when()
                .put(EndPoints.Activity)
                .then()
                .statusCode(200)
                .and().body("id", equalTo(ActivityId))
                .and().body("description", equalTo("123"))
                .and().body("projectId", equalTo(Project_id));
    }

    @Test
    public void putUpdateActivity_status_401() {
        given()
                .spec(spec)
                .body("{" +
                        "\"id\":" + "\"" + ActivityId + "\"," +
                        "\"name\":" + "\"" + ActivityName + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"," +
                        "\"description\":" + "\"" + "123" + "\"" +
                        "}")
                .when()
                .put(EndPoints.Activity)
                .then()
                .statusCode(401);
    }

    @Test
    public void putUpdateActivity_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"id\":" + "\"" + ActivityId + "\"," +
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
