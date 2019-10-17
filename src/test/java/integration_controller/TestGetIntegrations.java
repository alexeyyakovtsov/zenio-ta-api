package integration_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class TestGetIntegrations extends SuiteTest {

    @Test
    @DisplayName("GET Integrations status = 200")
    public void getIntegrations_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get(EndPoints.Integrations)
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("GET Integrations status = 401")
    public void getIntegrations_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.Integrations)
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("GET Integrations status = 404")
    public void getIntegrations_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/integrationss")
                .then()
                .statusCode(404);
    }
}
