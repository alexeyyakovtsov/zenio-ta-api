package workspace_controller;

import TestSuite.EndPoints;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestPutUpdateWorkspace {

    @Test
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
