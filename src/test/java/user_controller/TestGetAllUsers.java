package user_controller;

import TestSuite.EndPoints;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static TestSuite.SuiteTest.*;

public class TestGetAllUsers {

    @Test
    public void getAllUsers_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get(EndPoints.GetAllUsers)
                .then()
                .statusCode(200)
                .and()
                .body(matchesJsonSchemaInClasspath("getAllUsers.json"));
    }

    @Test
    public void getAllUsers_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.GetAllUsers)
                .then()
                .statusCode(401);
    }

    @Test
    public void getAllUsers_status_404(){
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/us1eers")
                .then()
                .statusCode(404);
    }
}
