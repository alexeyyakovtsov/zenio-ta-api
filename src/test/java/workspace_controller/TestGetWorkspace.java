package workspace_controller;

import TestSuite.EndPoints;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static TestSuite.SuiteTest.*;

public class TestGetWorkspace {

    @Test
    public void getUserWorkspaces_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get(EndPoints.Workspaces)
                .then()
                .statusCode(200);
    }

    @Test
    public void getUserWorkspaces_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.Workspaces)
                .then()
                .statusCode(401);
    }

    @Test
    public void getUserWorkspaces_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/workspacees")
                .then()
                .statusCode(404);
    }
}
