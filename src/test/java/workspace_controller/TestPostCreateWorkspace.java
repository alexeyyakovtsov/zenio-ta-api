package workspace_controller;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static parameters.Configurations.URL_Dev;
import static parameters.Configurations.WorkspaceNew;

public class TestPostCreateWorkspace {

    private static Cookies cookies;

    @Before
    public void Login() {
        cookies = given()
                .baseUri(URL_Dev)
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
                .baseUri(URL_Dev)
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
                .baseUri(URL_Dev)
                .when()
                .contentType(ContentType.JSON)
                .body(WorkspaceNew)
                .post("/api/workspaces")
                .then()
                .statusCode(401);
    }
}
