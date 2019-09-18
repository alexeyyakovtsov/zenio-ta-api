package user_controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static parameters.Configurations.URL_Dev;

import parameters.Configurations;

public class TestPostInviteUser {

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
    public void postInviteUser_status200() {

        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(Configurations.BodyEmail)
                .when()
                .post("/api/users/invite")
                .then()
                .statusCode(200);
    }

    @Test
    public void postInviteUser_status401() {

        given()
                .baseUri(URL_Dev)
                .when()
                .post("/api/users/invite")
                .then()
                .statusCode(401);
    }

    @Test
    public void postInviteUser_status403() {
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
                .body(Configurations.BodyEmail)
                .when()
                .post("/api/users/invite")
                .then().log().all()
                .statusCode(403);
    }

    @Test
    public void postInviteUser_status404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(Configurations.BodyEmail)
                .when()
                .post("/api/users/invitee")
                .then()
                .statusCode(404);
    }
}
