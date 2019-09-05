package user_controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestGetCurrentUser {

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
    public void getCurrentUser_200() {
        given()
                .baseUri("https://dev.zenio.co/")
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/users/me")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("getCurrentUser.json"))
                .and().body("id", equalTo(1))
                .and().body("username", equalTo("zenio"))
                .and().body("email", equalTo("zenio@zensoft.io"))
                .and().body("active", equalTo(true))
                .and().body("enabled", equalTo(true))
                .and().body("roles", hasItems("ADMIN"));
    }

    @Test
    public void getCurrentUser_status401() {
        given()
                .baseUri("https://dev.zenio.co")
                .when()
                .get("/api/users/me")
                .then()
                .statusCode(401);
    }

    @Test
    public void getCurrentUser_status404() {
        given()
                .baseUri("https://dev.zenio.co")
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/users/meу")
                .then()
                .statusCode(404);
    }
}
