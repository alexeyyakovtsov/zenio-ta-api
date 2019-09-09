package user_controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.junit.Before;
import org.junit.Test;
import parameters.Configurations;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TestPostRestorePassword {

    private static Cookies cookies;

    @Before
    public void Login() {
        cookies = RestAssured.given()
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
    public void postRestorePassword_200() {
        given()
                .baseUri("https://dev.zenio.co")
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(Configurations.BodyEmail)
                .when()
                .post("/api/users/restore")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("postRestorePassword.json"));
    }

    @Test
    public void postRestorePassword_401() {
        given()
                .baseUri("https://dev.zenio.co")
                .when()
                .post("/api/users/restore")
                .then()
                .statusCode(401);
    }

    @Test
    public void postRestorePassword_403() {
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
                .body(Configurations.BodyEmail)
                .when()
                .post("/api/users/restore")
                .then()
                .statusCode(403);
    }

    @Test
    public void postRestorePassword_404() {
        given()
                .baseUri("https://dev.zenio.co")
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(Configurations.BodyEmail)
                .when()
                .post("/api/users/restoore")
                .then()
                .statusCode(404);
    }
}
