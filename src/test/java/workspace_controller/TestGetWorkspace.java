package workspace_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static TestSuite.SuiteTest.*;

public class TestGetWorkspace {

    @Test
    public void getUserWorkspaces_status_200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/workspaces")
                .then()
                .statusCode(200);
    }

    @Test
    public void getUserWorkspaces_status_401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/workspaces")
                .then()
                .statusCode(401);
    }

    @Test
    public void getUserWorkspaces_status_404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/workspacees")
                .then()
                .statusCode(404);
    }
}
