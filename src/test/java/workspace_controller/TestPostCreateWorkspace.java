package workspace_controller;

import org.junit.Test;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static TestSuite.SuiteTest.*;

public class TestPostCreateWorkspace {

    @Test
    public void postCreateWorkspace_status_200() {
            given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .body(WorkspaceNew)
                .post("/api/workspaces")
                .then()
                .statusCode(201);
    }

    @Test
    public void postCreateWorkspace_status_401() {
        given()
                .spec(spec)
                .when()
                .body(WorkspaceNew)
                .post("/api/workspaces")
                .then()
                .statusCode(401);
    }
}
