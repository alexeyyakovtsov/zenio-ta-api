package workspace_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Ignore;
import org.junit.Test;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;

public class TestPostCreateWorkspace extends SuiteTest {

    @Ignore
    @Test
    @DisplayName("POST Create Workspace status = 200")
    public void postCreateWorkspace_status_200() {
            given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .body(WorkspaceNew)
                .post(EndPoints.Workspaces)
                .then()
                .statusCode(201);
    }

    @Ignore
    @Test
    @DisplayName("POST Create Workspace status = 401")
    public void postCreateWorkspace_status_401() {
        given()
                .spec(spec)
                .when()
                .body(WorkspaceNew)
                .post(EndPoints.Workspaces)
                .then()
                .statusCode(401);
    }
}
