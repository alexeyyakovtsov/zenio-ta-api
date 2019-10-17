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
}
