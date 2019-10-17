package project_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestPutUpdateProject extends SuiteTest {

    @Test
    @DisplayName("PUT Update Project status = 200")
    public void putUpdateProject_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + ProjectUpdateName + "\"" +
                        "}")
                .when()
                .put(EndPoints.UpdateProjectId)
                .then()
                .statusCode(200)
                .and().body("id", equalTo(Project_update_id))
                .and().body("workspaceId", equalTo(4))
                .and().body("deleted", equalTo(false))
                .and().body("ownerId", equalTo(1));
    }

    @Test
    @DisplayName("PUT Update Project status = 401")
    public void putUpdateProject_status_401() {
        given()
                .spec(spec)
                .body("{" +
                        "\"name\":" + "\"" + ProjectUpdateName + "\"" +
                        "}")
                .when()
                .put(EndPoints.UpdateProjectId)
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("PUT Update Project status = 404")
    public void putUpdateProject_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + ProjectUpdateName + "\"" +
                        "}")
                .when()
                .put("/api/projectts")
                .then()
                .statusCode(404);
    }
}
