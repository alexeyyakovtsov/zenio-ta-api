package integration_controller;

import TestSuite.EndPoints;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static TestSuite.SuiteTest.*;

public class TestGetIntegrations {

    @Test
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
    public void getIntegrations_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.Integrations)
                .then()
                .statusCode(401);
    }

    @Test
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
