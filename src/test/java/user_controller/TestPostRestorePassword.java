package user_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestPostRestorePassword {


    @Test
    public void postRestorePassword_200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(User_restore_password_email)
                .when()
                .post("/api/users/restore")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("postRestorePassword.json"));
    }

    @Test
    public void postRestorePassword_404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(User_restore_password_email)
                .when()
                .post("/api/users/restoore")
                .then()
                .statusCode(404);
    }
}
