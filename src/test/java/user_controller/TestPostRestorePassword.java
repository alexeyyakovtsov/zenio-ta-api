package user_controller;

import org.junit.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestPostRestorePassword {


    @Test
    public void postRestorePassword_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body(User_restore_password_email)
                .when()
                .post("/api/users/restore")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("postRestorePassword.json"));
    }

    @Test
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
