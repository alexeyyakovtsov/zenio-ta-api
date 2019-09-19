package project_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestPostCreateProject {

    @Test
    public void postCreateProject_status200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
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
    public void postCreateProject_status401() {
        given()
                .baseUri(URL_Dev)
                .when()
                .contentType(ContentType.JSON)
                .body(
                        "{" +
                                "\"name\":" + "\"" + ProjectName + "\"," +
                                "\"workspaceId\":" + "\"" + Workspace_id + "\"" +
                                "}")
                .post("/api/projects")
                .then()
                .statusCode(401);
    }

    @Test
    public void postCreateProject_status404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .when()
                .contentType(ContentType.JSON)
                .body(
                        "{" +
                                "\"name\":" + "\"" + ProjectName + "\"," +
                                "\"workspaceId\":" + "\"" + Workspace_id + "\"" +
                                "}")
                .post("/api/projectss")
                .then()
                .statusCode(404);
    }
}
