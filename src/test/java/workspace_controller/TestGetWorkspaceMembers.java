package workspace_controller;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static parameters.Configurations.*;

public class TestGetWorkspaceMembers {

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
    public void getWorkspaceMembers_status200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/workspaces/" + Workspace_id + "/users")
                .then()
                .statusCode(200)
                .and()
                .body(matchesJsonSchemaInClasspath("getWorkspaceMembers.json"));
    }

    @Test
    public void getWorkspaceMembers_status401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/workspaces/" + Workspace_id + "/users")
                .then()
                .statusCode(401);
    }

    @Test
    public void getWorkspaceMembers_status404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/workspaces" + Workspace_id + "/userrs")
                .then()
                .statusCode(404);
    }
}
