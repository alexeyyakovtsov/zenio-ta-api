package workspace_controller;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static parameters.Configurations.URL_Dev;
import static parameters.Configurations.Workspace_update_id;

public class TestGetWorkspaceId {

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
    public void getWorkspaceId_status200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/workspaces/" + Workspace_update_id)
                .then()
                .statusCode(200)
                .and().body("id", equalTo(27))
                .and().body("owned", equalTo(true));
    }

    @Test
    public void getWorkspaceId_status401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/workspaces/" + Workspace_update_id)
                .then()
                .statusCode(401);
    }

    @Test
    public void getWorkspaceId_status404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/workspacess/" + Workspace_update_id)
                .then()
                .statusCode(404);
    }
}
