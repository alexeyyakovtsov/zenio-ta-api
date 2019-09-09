package user_controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import parameters.Configurations;

public class TestPostInviteUser {

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
    public void postInviteUser_status200() {

        given()
                .baseUri("https://dev.zenio.co")
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
                .baseUri("https://dev.zenio.co")
                .when()
                .post("/api/users/invite")
                .then()
                .statusCode(401);
    }

    @Test
    public void postInviteUser_status403() {
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
                .post("/api/users/invite")
                .then().log().all()
                .statusCode(403);
    }

    @Test
    public void postInviteUser_status404() {
        given()
                .baseUri("https://dev.zenio.co")
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(Configurations.BodyEmail)
                .when()
                .post("/api/users/invitee")
                .then()
                .statusCode(404);
    }
}
