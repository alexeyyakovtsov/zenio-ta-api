package major_release_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

public class TestPutUpdateMajorRelease extends SuiteTest {

    @Test
    @DisplayName("PUT Update Major Release status = 200")
    public void putUpdateMajorRelease_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + MajorReleaseName + "\"" +
                        "}")
                .when()
                .put(EndPoints.PutUpdateMajorRelease)
                .then()
                .statusCode(200)
                .and().body("id", equalTo(MajorRelease));
    }

    @Test
    @DisplayName("PUT Update Major Release status = 401")
    public void putUpdateMajorRelease_status_401() {
        given()
                .spec(spec)
                .body("{" +
                        "\"name\":" + "\"" + MajorReleaseName + "\"" +
                        "}")
                .when()
                .put(EndPoints.PutUpdateMajorRelease)
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("PUT Update Major Release status = 404")
    public void putUpdateMajorRelease_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + MajorReleaseName + "\"" +
                        "}")
                .when()
                .put("/api/projects/" + Project_id + "/releases/majorr/" + MajorRelease)
                .then()
                .statusCode(404);
    }
}
