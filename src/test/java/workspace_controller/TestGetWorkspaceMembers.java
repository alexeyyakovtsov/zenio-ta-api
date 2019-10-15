package workspace_controller;

import TestSuite.EndPoints;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestGetWorkspaceMembers {

    @Test
    public void getWorkspaceMembers_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get(EndPoints.GetWorkspaceMembers)
                .then()
                .statusCode(200)
                .and().body(matchesJsonSchemaInClasspath("getWorkspaceMembers.json"));
    }

    @Test
    public void getWorkspaceMembers_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.GetWorkspaceMembers)
                .then()
                .statusCode(401);
    }

    @Test
    public void getWorkspaceMembers_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/workspaces" + Workspace_id + "/userrs")
                .then()
                .statusCode(404);
    }
}
