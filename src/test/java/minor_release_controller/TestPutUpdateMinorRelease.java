package minor_release_controller;

import TestSuite.EndPoints;
import org.junit.Test;

import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static TestSuite.SuiteTest.*;

public class TestPutUpdateMinorRelease {

    @Test
    public void putUpdateMinorRelease_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + MinorReleaseName + "\"," +
                        "\"description\":" + "\"" + Description + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .put(EndPoints.GetMinorReleaseId)
                .then()
                .statusCode(200)
                .and().body("id", equalTo(MinorRelease))
                .and().body("projectId", equalTo(Project_id))
                .and().body("majorReleaseId", equalTo(MajorRelease));
    }

    @Test
    public void putUpdateMinorRelease_status_401() {
        given()
                .spec(spec)
                .body("{" +
                        "\"name\":" + "\"" + MinorReleaseName + "\"," +
                        "\"description\":" + "\"" + Description + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .put(EndPoints.GetMinorReleaseId)
                .then()
                .statusCode(401);
    }

    @Test
    public void putUpdateMinorRelease_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + MinorReleaseName + "\"," +
                        "\"description\":" + "\"" + Description + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .put("/api/projects/" + Project_id + "/releases/minorr")
                .then()
                .statusCode(404);
    }
}
