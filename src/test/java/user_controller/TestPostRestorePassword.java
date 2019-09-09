package user_controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static parameters.Configurations.URL_Dev;
import static parameters.Configurations.User_restore_password_email;

public class TestPostRestorePassword {

    private static Cookies cookies;

    @Before
    public void Login() {
        cookies = RestAssured.given()
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
    public void postRestorePassword_200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(User_restore_password_email)
                .when()
                .post("/api/users/restore")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("postRestorePassword.json"));
    }

    @Test
    public void postRestorePassword_404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(User_restore_password_email)
                .when()
                .post("/api/users/restoore")
                .then()
                .statusCode(404);
    }
}
