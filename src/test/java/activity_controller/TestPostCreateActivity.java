package activity_controller;

import io.restassured.http.ContentType;
import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestPostCreateActivity {

    @Test
     public void postCreateActivity_status_200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"name\":" + "\"" + ActivityName + "\"," +
                        "\"areaId\":" + "\"" + AreaId + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .post("/api/projects/" + Project_id + "/activities")
                .then()
                .statusCode(200)
                .and().body("areaId", equalTo(AreaId))
                .and().body("projectId", equalTo(Project_id));
    }

    @Test
    public void postCreateActivity_status_401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"name\":" + "\"" + ActivityName + "\"," +
                        "\"areaId\":" + "\"" + AreaId + "\"" +
                        "}")
                .when()
                .post("/api/projects/" + Project_id + "/activities")
                .then()
                .statusCode(401);
    }

    @Test
    public void postCreateActivity_status_404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
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
