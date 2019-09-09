package workspace_controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static parameters.Configurations.WorkspaceNew;
import static parameters.Configurations.Workspace_name;

public class TestPostCreateWorkspace {

    private static Cookies cookies;

    @Before
    public void Login() {
        cookies = given()
                .baseUri("https://dev.zenio.co")
                .urlEncodingEnabled(true)
                .param("email", "zenio@zensoft.io")
                .param("password", "12345678")
                .when()
                .post("/login")
                .then()
                .statusCode(302)
                .extract()
                .response()
                .getDetailedCookies();
    }

    @Test
    public void postCreateWorkspace_status200() {
            given()
                .baseUri("https://dev.zenio.co")
                .cookies(cookies)
                .when()
                .contentType(ContentType.JSON)
                .body(WorkspaceNew)
                .post("/api/workspaces")
                .then()
                .statusCode(201);
    }

    @Test
    public void postCreateWorkspace_status401() {
        given()
                .baseUri("https://dev.zenio.co")
                .when()
                .contentType(ContentType.JSON)
                .body(WorkspaceNew)
                .post("/api/workspaces")
                .then()
                .statusCode(401);
    }

    @Test
    public void postCreateWorkspace_status404() {
        given()
                .baseUri("https://dev.zenio.co")
                .cookies(cookies)
                .when()
                .contentType(ContentType.JSON)
                .body(WorkspaceNew)
                .post("/api/workspacesss")
                .then()
                .statusCode(404);
    }
}
