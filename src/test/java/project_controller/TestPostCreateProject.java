package project_controller;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestPostCreateProject {

    @Test
    public void postCreateProject_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + ProjectName + "\"," +
                        "\"workspaceId\":" + "\"" + Workspace_id + "\"" +
                        "}")
                .when()
                .post("/api/projects")
                .then()
                .statusCode(200)
                .and().body("workspaceId", equalTo(4))
                .and().body("deleted", equalTo(false))
                .and().body("ownerId", equalTo(1))
                .and().body("membersCount", equalTo(1));
    }

    @Test
    public void postCreateProject_status_401() {
        given()
                .spec(spec)
                .when()
                .body("{" +
                        "\"name\":" + "\"" + ProjectName + "\"," +
                        "\"workspaceId\":" + "\"" + Workspace_id + "\"" +
                        "}")
                .post("/api/projects")
                .then()
                .statusCode(401);
    }

    @Test
    public void postCreateProject_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .body("{" +
                        "\"name\":" + "\"" + ProjectName + "\"," +
                        "\"workspaceId\":" + "\"" + Workspace_id + "\"" +
                        "}")
                .post("/api/projectss")
                .then()
                .statusCode(404);
    }
}
