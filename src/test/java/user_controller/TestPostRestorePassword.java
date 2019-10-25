package user_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

public class TestPostRestorePassword extends SuiteTest {

    @Test
    @DisplayName("POST Restore password status = 200")
    public void postRestorePassword_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body(User_restore_password_email)
                .when()
                .post(EndPoints.RestorePassword)
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("POST Restore password status = 404")
    public void postRestorePassword_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body(User_restore_password_email)
                .when()
                .post("/api/users/restoore")
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
                .post(EndPoints.RestorePassword)
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
                .post(EndPoints.RestorePassword)
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
                .post(EndPoints.RestorePassword)
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
                .post(EndPoints.RestorePassword)
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
                .post(EndPoints.RestorePassword)
                .then()
                .statusCode(400);
    }
}