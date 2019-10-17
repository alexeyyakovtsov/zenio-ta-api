package major_release_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

public class TestPostCreateMajorRelease extends SuiteTest {

    @Test
    @DisplayName("POST Create Major Release status = 200")
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
    @DisplayName("POST Create Major Release status = 401")
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
    @DisplayName("POST Create Major Release status = 404")
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
