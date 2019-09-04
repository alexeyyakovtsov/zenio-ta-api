package user_controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.given;
import static io.restassured.config.RedirectConfig.redirectConfig;
import static parameters.Configurations.*;


public class TestGetAllUsers {

    private static Cookies cookies;

    @BeforeClass
    public static void exampleOfLogin() {
        String body = "login_password.json";
        cookies = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .post(URL_Dev_Login)
                .then()
                .statusCode(200)
                .extract()
                .response()
                .getDetailedCookies();
    }

    @BeforeEach
    public void configureRestAssured() {
        RestAssured.baseURI = "https://dev.zenio.co";
        RestAssured.requestSpecification = given()
                .header("Language", "en");
    }

    @Test
    public void getAllUsers() {
        given()
                .config(RestAssured.config().redirect(redirectConfig().followRedirects(false)))
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get( URL_Dev_API + "/users")
                .then()
                .statusCode(200);
    }
}
