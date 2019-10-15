package workspace_controller;

import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestGetWorkspaceId {

    @Test
    public void getWorkspaceId_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/workspaces/" + Workspace_update_id)
                .then()
                .statusCode(200)
                .and().body("id", equalTo(Workspace_update_id))
                .and().body("owned", equalTo(true))
                .and().body("projects.id", hasItems(1334))
                .and().body("projects.workspaceId", hasItems(Workspace_update_id));
    }

    @Test
    public void getWorkspaceId_status_401() {
        given()
                .spec(spec)
                .when()
                .get("/api/workspaces/" + Workspace_update_id)
                .then()
                .statusCode(401);
    }

    @Test
    public void getWorkspaceId_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/workspacess/" + Workspace_update_id)
                .then()
                .statusCode(404);
    }
}
