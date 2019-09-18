package project_controller;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

public class TestPostCreateProject {

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
    public void postCreateProject_status200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .when()
                .contentType(ContentType.JSON)
                .body(
                        "{" +
                                "\"name\":" + "\"" + ProjectName + "\"," +
                                "\"workspaceId\":" + "\"" + Workspace_id + "\"" +
                        "}")
                .post("/api/projects")
                .then()
                .statusCode(200)
                .and().body("workspaceId", equalTo(4))
                .and().body("deleted", equalTo(false))
                .and().body("ownerId", equalTo(1))
                .and().body("membersCount", equalTo(1));
    }

    @Test
    public void postCreateProject_status401() {
        given()
                .baseUri(URL_Dev)
                .when()
                .contentType(ContentType.JSON)
                .body(
                        "{" +
                                "\"name\":" + "\"" + ProjectName + "\"," +
                                "\"workspaceId\":" + "\"" + Workspace_id + "\"" +
                                "}")
                .post("/api/projects")
                .then()
                .statusCode(401);
    }

    @Test
    public void postCreateProject_status404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .when()
                .contentType(ContentType.JSON)
                .body(
                        "{" +
                                "\"name\":" + "\"" + ProjectName + "\"," +
                                "\"workspaceId\":" + "\"" + Workspace_id + "\"" +
                                "}")
                .post("/api/projectss")
                .then()
                .statusCode(404);
    }
}
