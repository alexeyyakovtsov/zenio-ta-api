package user_controller;

import org.junit.Test;
import static io.restassured.RestAssured.given;
import static TestSuite.SuiteTest.*;

import parameters.Configurations;

public class TestPostInviteUser {

    @Test
    public void postInviteUser_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body(Configurations.BodyEmail)
                .when()
                .post("/api/users/invite")
                .then()
                .statusCode(200);
    }

    @Test
    public void postInviteUser_status_401() {
        given()
                .spec(spec)
                .when()
                .post("/api/users/invite")
                .then()
                .statusCode(401);
    }

    @Test
    public void postInviteUser_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body(Configurations.BodyEmail)
                .when()
                .post("/api/users/invitee")
                .then()
                .statusCode(404);
    }
}
