package area_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static TestSuite.SuiteTest.*;

public class TestPostCreateArea {

    @Test
    public void postCreateArea_status200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"name\":" + "\"" + AreaName + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"," +
                        "\"anchorId\":" + "\"" + AreaId + "\"," +
                        "\"position\":" + "\"" + "AFTER" + "\"" +
                        "}")
                .when()
                .post("/api/projects/" + Project_id + "/areas")
                .then()
                .statusCode(200)
                .and().body("projectId", equalTo(31));
    }

    @Test
    public void postCreateArea_status401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"name\":" + "\"" + AreaName + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "\"anchorId\":" + "\"" + AreaId + "\"" +
                        "\"position\":" + "\"" + "AFTER" + "\"" +
                        "}")
                .when()
                .post("/api/projects/" + Project_id + "/areas")
                .then()
                .statusCode(401);
    }

    @Test
    public void postCreateArea_status404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
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
