package user_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class TestGetAllUsers extends SuiteTest {

    @Test
    @DisplayName("GET All Users status = 200")
    public void getAllUsers_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get(EndPoints.GetAllUsers)
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("GET All Users status = 401")
    public void getAllUsers_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.GetAllUsers)
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("GET All Users status = 404")
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
