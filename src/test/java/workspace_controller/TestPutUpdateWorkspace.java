package workspace_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

public class TestPutUpdateWorkspace extends SuiteTest {

    @Test
    @DisplayName("PUT Update Workspace status = 200")
    public void putUpdateWorkspace_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body(WorkspaceNew)
                .when()
                .put(EndPoints.UpdateWorkspaceId)
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("PUT Update Workspace status = 401")
    public void putUpdateWorkspace_status_401() {
        given()
                .spec(spec)
                .body(WorkspaceNew)
                .when()
                .put(EndPoints.UpdateWorkspaceId)
                .then()
                .statusCode(401);
    }
}
