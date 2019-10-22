package user_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import parameters.Configurations;

public class TestPostInviteUser extends SuiteTest {

    @Test
    @DisplayName("POST Invite User status = 200")
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
    @DisplayName("POST Invite User status = 401")
    public void postInviteUser_status_401() {
        given()
                .spec(spec)
                .when()
                .post(EndPoints.InviteUser)
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("POST Invite User status = 404")
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

    @Test
    @DisplayName("POST Negative Test 1 status = 400")
    public void postNegativeTest1_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .post(EndPoints.InviteUser)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative Test 2 status = 400")
    public void postNegativeTest2_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{\"emails\":" + "[\"" + "123" + "\"]}")
                .when()
                .post(EndPoints.InviteUser)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative Test 3 status = 400")
    public void postNegativeTest3_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{\"emails\":" + "[\"" + "xxx.xx" + "\"]}")
                .when()
                .post(EndPoints.InviteUser)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative Test 4 status = 400")
    public void postNegativeTest4_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{\"emails\":" + "[\"" + "xxx@xx" + "\"]}")
                .when()
                .post(EndPoints.InviteUser)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative Test 5 status = 400")
    public void postNegativeTest5_status_400() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{\"emails\":" + "[\"" + "@xx.com" + "\"]}")
                .when()
                .post(EndPoints.InviteUser)
                .then()
                .statusCode(400);
    }
}
