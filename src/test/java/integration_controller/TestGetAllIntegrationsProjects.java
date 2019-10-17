package integration_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static TestSuite.SuiteTest.*;

public class TestGetAllIntegrationsProjects extends SuiteTest {

    @Test
    @DisplayName("GET Integrations project status = 200")
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
    @DisplayName("GET Integrations project status = 401")
    public void getAllIntegrationsProjects__status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.GetAllIntegrations)
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("GET Integrations project status = 404")
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
