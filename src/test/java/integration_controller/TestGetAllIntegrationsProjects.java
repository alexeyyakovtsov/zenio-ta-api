package integration_controller;

import TestSuite.EndPoints;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static TestSuite.SuiteTest.*;

public class TestGetAllIntegrationsProjects {

    @Test
    public void getAllIntegrationsProjects_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get(EndPoints.GetAllIntegrations)
                .then()
                .statusCode(200);
    }

    @Test
    public void getAllIntegrationsProjects__status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.GetAllIntegrations)
                .then()
                .statusCode(401);
    }

    @Test
    public void getAllIntegrationsProjects__status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/integrationss/projects")
                .then()
                .statusCode(404);
    }
}
