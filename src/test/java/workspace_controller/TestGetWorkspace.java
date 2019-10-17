package workspace_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class TestGetWorkspace extends SuiteTest {

    @Test
    @DisplayName("GET Workspace status = 200")
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
    @DisplayName("GET Workspace status = 401")
    public void getUserWorkspaces_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.Workspaces)
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("GET Workspace status = 404")
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
