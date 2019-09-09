package workspace_controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TestGetWorkspace {

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
    public void getUserWorkspaces_status200() {
        given()
                .baseUri("https://dev.zenio.co")
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/workspaces")
                .then()
                .statusCode(200);
    }

    @Test
    public void getUserWorkspaces_status401() {
        given()
                .baseUri("https://dev.zenio.co")
                .contentType(ContentType.JSON)
                .when()
                .get("/api/workspaces")
                .then()
                .statusCode(401);
    }

    @Test
    public void getUserWorkspaces_status403() {
        cookies = RestAssured.given()
                .baseUri("https://dev.zenio.co")
                .urlEncodingEnabled(true)
                .param("email", "alexey.yakovtsov@zensoft.io")
                .param("password", "12345678")
                .when()
                .post("/login")
                .then()
                .statusCode(302)
                .extract()
                .response()
                .getDetailedCookies();

        given()
                .baseUri("https://dev.zenio.co")
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/workspaces")
                .then()
                .statusCode(200);
    }

    @Test
    public void getUserWorkspaces_status404() {
        given()
                .baseUri("https://dev.zenio.co")
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/workspacees")
                .then()
                .statusCode(404);
    }
}
