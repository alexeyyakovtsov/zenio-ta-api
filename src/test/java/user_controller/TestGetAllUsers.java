package user_controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static parameters.Configurations.URL_Dev;


public class TestGetAllUsers {

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
    public void getAllUsers_status200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get( "/api/users")
                .then()
                .statusCode(200)
                .and()
                .body(matchesJsonSchemaInClasspath("getAllUsers.json"));
    }

    @Test
    public void getAllUsers_status401() {
        given()
                .baseUri(URL_Dev)
                .when()
                .get("/api/users")
                .then()
                .statusCode(401);
    }

    @Test
    public void getAllUsers_status403() {
        cookies = RestAssured.given()
                .baseUri(URL_Dev)
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
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/users")
                .then()
                .statusCode(403);
    }

    @Test
    public void getAllUsers_status404(){
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/us1eers")
                .then()
                .statusCode(404);
    }
}
