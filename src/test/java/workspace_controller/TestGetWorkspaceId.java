package workspace_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestGetWorkspaceId {

    @Test
    public void getWorkspaceId_status200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/workspaces/" + Workspace_update_id)
                .then()
                .statusCode(200)
                .and().body("id", equalTo(27))
                .and().body("owned", equalTo(true));
    }

    @Test
    public void getWorkspaceId_status401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/workspaces/" + Workspace_update_id)
                .then()
                .statusCode(401);
    }

    @Test
    public void getWorkspaceId_status404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/workspacess/" + Workspace_update_id)
                .then()
                .statusCode(404);
    }
}
