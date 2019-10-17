package user_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;
import static TestSuite.SuiteTest.*;

public class TestGetCurrentUser extends SuiteTest {

    @Test
    public void getCurrentUser_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get(EndPoints.GetCurrentUser)
                .then()
                .statusCode(200)
                .and().body("username", equalTo("zenio"))
                .and().body("email", equalTo("zenio@zensoft.io"))
                .and().body("active", equalTo(true))
                .and().body("enabled", equalTo(true))
                .and().body("roles", hasItems("ADMIN"));
    }

    @Test
    public void getCurrentUser_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.GetCurrentUser)
                .then()
                .statusCode(401);
    }

    @Test
    public void getCurrentUser_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/users/meу")
                .then()
                .statusCode(404);
    }
}
