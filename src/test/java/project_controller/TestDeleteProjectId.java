package project_controller;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static parameters.Configurations.Project_deleted_id;
import static parameters.Configurations.URL_Dev;

public class TestDeleteProjectId {

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
    public void deleteProjectId_status200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .delete("/api/projects/" + Project_deleted_id)
                .then()
                .statusCode(204);
    }

    @Test
    public void deleteProjectId_status401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .when()
                .delete("/api/projects" + Project_deleted_id)
                .then()
                .statusCode(401);
    }

    @Test
    public void deleteProjectId_status404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .delete("/api/projectts" + Project_deleted_id)
                .then()
                .statusCode(404);
    }
}
