package workspace_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

public class TestGetWorkspaceMembers extends SuiteTest {

    @Test
    @DisplayName("GET Workspace Members status = 200")
    public void getWorkspaceMembers_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get(EndPoints.GetWorkspaceMembers)
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("GET Workspace Members status = 401")
    public void getWorkspaceMembers_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.GetWorkspaceMembers)
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("GET Workspace Members status = 404")
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
