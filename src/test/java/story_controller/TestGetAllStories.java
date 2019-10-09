package story_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestGetAllStories {

    @Test
    public void getAllStories_status_200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/projects/" + Project_id + "/stories")
                .then()
                .statusCode(200);
    }

    @Test
    public void getAllStories_status_401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/projects/" + Project_id + "/stories")
                .then()
                .statusCode(401);
    }

    @Test
    public void getAllStories_status_404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/projects/" + Project_id + "/storiess")
                .then()
                .statusCode(404);
    }
}
