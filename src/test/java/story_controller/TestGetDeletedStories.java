package story_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestGetDeletedStories {

    @Test
    public void getDeletedStories_status_200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/projects/" + Project_id + "/stories/deleted")
                .then()
                .statusCode(200);
    }

    @Test
    public void getDeletedStories_status_401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/projects/" + Project_id + "/stories/deleted")
                .then()
                .statusCode(401);
    }

  /*  @Test
    public void getDeletedStories_status_404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/projects/" + Project_id + "/stories/deletedd")
                .then()
                .statusCode(404);
    }*/
}
