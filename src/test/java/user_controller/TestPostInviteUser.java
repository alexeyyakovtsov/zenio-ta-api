package user_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

import parameters.Configurations;

public class TestPostInviteUser {

    @Test
    public void postInviteUser_status_200() {

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
    public void postInviteUser_status_401() {

        given()
                .baseUri(URL_Dev)
                .when()
                .post("/api/users/invite")
                .then()
                .statusCode(401);
    }

    @Test
    public void postInviteUser_status_404() {
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
