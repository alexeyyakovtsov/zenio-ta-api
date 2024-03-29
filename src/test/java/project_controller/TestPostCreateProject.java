package project_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

public class TestPostCreateProject extends SuiteTest {

    @Test
    @DisplayName("POST Create Project status = 200")
    public void postCreateProject_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + ProjectName + "\"," +
                        "\"workspaceId\":" + "\"" + Workspace_id + "\"" +
                        "}")
                .when()
                .post(EndPoints.UserProjects)
                .then()
                .statusCode(201)
                .and().body("workspaceId", equalTo(4))
                .and().body("deleted", equalTo(false))
                .and().body("ownerId", equalTo(1))
                .and().body("membersCount", equalTo(1));
    }

    @Test
    @DisplayName("POST Create Project status = 401")
    public void postCreateProject_status_401() {
        given()
                .spec(spec)
                .when()
                .body("{" +
                        "\"name\":" + "\"" + ProjectName + "\"," +
                        "\"workspaceId\":" + "\"" + Workspace_id + "\"" +
                        "}")
                .post(EndPoints.UserProjects)
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("POST Create Project status = 404")
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

    @Test
    @DisplayName("POST Negative Test 1 status = 400")
    public void postNegativeTest1_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"workspaceId\":" + "\"" + Workspace_id + "\"" +
                        "}")
                .when()
                .post(EndPoints.UserProjects)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative Test 2 status = 400")
    public void postNegativeTest2_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + ProjectName + "\"," +
                        "\"workspaceId\":" + "\"" + "QATest123" + "\"" +
                        "}")
                .when()
                .post(EndPoints.UserProjects)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative Test 3 status = 400")
    public void postNegativeTest3_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + ProjectName + "\"," +
                        "\"integrationId\":" + "\"" + "QATest123" + "\"," +
                        "\"workspaceId\":" + "\"" + Workspace_id + "\"" +
                        "}")
                .when()
                .post(EndPoints.UserProjects)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative Test 4 status = 400")
    public void postNegativeTest4_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + ProjectName + "\"," +
                        "\"externalProjectId\":" + "\"" + "QATest123" + "\"," +
                        "\"workspaceId\":" + "\"" + Workspace_id + "\"" +
                        "}")
                .when()
                .post(EndPoints.UserProjects)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative Test 5 status = 400")
    public void postNegativeTest5_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"name\":" + "\"" + ProjectName + "\"," +
                        "\"epicIds\":" + "\"" + "QATest123" + "\"," +
                        "\"workspaceId\":" + "\"" + Workspace_id + "\"" +
                        "}")
                .when()
                .post(EndPoints.UserProjects)
                .then()
                .statusCode(400);
    }
}
