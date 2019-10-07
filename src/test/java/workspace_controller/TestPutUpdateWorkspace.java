package workspace_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestPutUpdateWorkspace {

    @Test
    public void putUpdateWorkspace_status_200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(WorkspaceNew)
                .when()
                .put("/api/workspaces/" + Workspace_update_id)
                .then()
                .statusCode(200);
    }

    @Test
    public void putUpdateWorkspace_status_401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .body(WorkspaceNew)
                .when()
                .put("/api/workspaces/" + Workspace_update_id)
                .then()
                .statusCode(401);
    }
}
