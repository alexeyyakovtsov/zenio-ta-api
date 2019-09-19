package workspace_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static TestSuite.SuiteTest.*;

public class TestPostCreateWorkspace {

    @Test
    public void postCreateWorkspace_status200() {
            given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .when()
                .contentType(ContentType.JSON)
                .body(WorkspaceNew)
                .post("/api/workspaces")
                .then()
                .statusCode(201);
    }

    @Test
    public void postCreateWorkspace_status401() {
        given()
                .baseUri(URL_Dev)
                .when()
                .contentType(ContentType.JSON)
                .body(WorkspaceNew)
                .post("/api/workspaces")
                .then()
                .statusCode(401);
    }
}
