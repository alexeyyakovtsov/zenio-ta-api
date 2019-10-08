package major_release_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestPutUpdateMajorRelease {

    @Test
    public void putUpdateMajorRelease_status_200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"name\":" + "\"" + MajorReleaseName + "\"" +
                        "}")
                .when()
                .put("/api/projects/" + Project_id + "/releases/major/" + MajorRelease)
                .then()
                .statusCode(202)
                .and().body("id", equalTo(MajorRelease));
    }

    @Test
    public void putUpdateMajorRelease_status_401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"name\":" + "\"" + MajorReleaseName + "\"" +
                        "}")
                .when()
                .put("/api/projects/" + Project_id + "/releases/major/" + MajorRelease)
                .then()
                .statusCode(401);
    }

    @Test
    public void putUpdateMajorRelease_status_404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"name\":" + "\"" + MajorReleaseName + "\"" +
                        "}")
                .when()
                .put("/api/projects/" + Project_id + "/releases/majorr/" + MajorRelease)
                .then()
                .statusCode(404);
    }
}
