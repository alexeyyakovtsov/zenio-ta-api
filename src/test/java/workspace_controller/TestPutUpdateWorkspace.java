package workspace_controller;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

public class TestPutUpdateWorkspace {

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
    public void putUpdateWorkspace_status200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(WorkspaceNew)
                .when()
                .put("/api/workspaces/" + Workspace_update_id)
                .then()
                .statusCode(200);
    }

    @Test
    public void putUpdateWorkspace_status401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .body(WorkspaceNew)
                .when()
                .put("/api/workspaces/" + Workspace_update_id)
                .then()
                .statusCode(401);
    }
}
