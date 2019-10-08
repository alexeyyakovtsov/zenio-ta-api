package minor_release_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static TestSuite.SuiteTest.*;

public class TestPutUpdateMinorRelease {

    @Test
    public void putUpdateMinorRelease_status_200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"id\":" + "\"" + MinorRelease + "\"," +
                        "\"name\":" + "\"" + MinorReleaseName + "\"," +
                        "\"description\":" + "\"" + Description + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .put("/api/projects/" + Project_id + "/releases/minor")
                .then()
                .statusCode(200)
                .and().body("id", equalTo(MinorRelease))
                .and().body("projectId", equalTo(Project_id))
                .and().body("majorReleaseId", equalTo(MajorRelease));
    }

    @Test
    public void putUpdateMinorRelease_status_401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"id\":" + "\"" + MinorRelease + "\"," +
                        "\"name\":" + "\"" + MinorReleaseName + "\"," +
                        "\"description\":" + "\"" + Description + "\"," +
                        "\"checksum\":" + "\"" + Checksum + "\"" +
                        "}")
                .when()
                .put("/api/projects/" + Project_id + "/releases/minor")
                .then()
                .statusCode(401);
    }

    @Test
    public void putUpdateMinorRelease_status_404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"id\":" + "\"" + MinorRelease + "\"," +
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
