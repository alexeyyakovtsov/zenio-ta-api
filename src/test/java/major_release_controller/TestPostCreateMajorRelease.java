package major_release_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestPostCreateMajorRelease {

    @Test
    public void postCreateMajorRelease_status_200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"name\":" + "\"" + MajorReleaseName + "\"" +
                        "}")
                .when()
                .post("/api/projects/" + Project_id + "/releases/major")
                .then()
                .statusCode(201);
    }

    @Test
    public void postCreateMajorRelease_status_401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"name\":" + "\"" + MajorReleaseName + "\"" +
                        "}")
                .when()
                .post("/api/projects/" + Project_id + "/releases/major")
                .then()
                .statusCode(401);
    }

    @Test
    public void postCreateMajorRelease_status_404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"name\":" + "\"" + MajorReleaseName + "\"" +
                        "}")
                .when()
                .post("/api/projects/" + Project_id + "/releases/majorr")
                .then()
                .statusCode(404);
    }
}
