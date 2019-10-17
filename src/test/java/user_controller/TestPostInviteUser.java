package user_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import org.junit.Test;
import static io.restassured.RestAssured.given;

import parameters.Configurations;

public class TestPostInviteUser extends SuiteTest {

    @Test
    public void postInviteUser_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body(Configurations.BodyEmail)
                .when()
                .post(EndPoints.InviteUser)
                .then()
                .statusCode(200);
    }

    @Test
    public void postInviteUser_status_401() {
        given()
                .spec(spec)
                .when()
                .post(EndPoints.InviteUser)
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
