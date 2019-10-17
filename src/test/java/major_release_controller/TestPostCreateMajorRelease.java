package major_release_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestPostCreateMajorRelease extends SuiteTest {

    @Test
    public void postCreateMajorRelease_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + MajorReleaseName + "\"" +
                        "}")
                .when()
                .post(EndPoints.PostCreateMajorRelease)
                .then()
                .statusCode(201);
    }

    @Test
    public void postCreateMajorRelease_status_401() {
        given()
                .spec(spec)
                .body("{" +
                        "\"name\":" + "\"" + MajorReleaseName + "\"" +
                        "}")
                .when()
                .post(EndPoints.PostCreateMajorRelease)
                .then()
                .statusCode(401);
    }

    @Test
    public void postCreateMajorRelease_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + MajorReleaseName + "\"" +
                        "}")
                .when()
                .post("/api/projects/" + Project_id + "/releases/majorr")
                .then()
                .statusCode(404);
    }
}
