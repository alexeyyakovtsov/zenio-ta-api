package integration_controller;

import TestSuite.EndPoints;
import org.junit.Test;

import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static TestSuite.SuiteTest.*;

public class TestPostCreateIntegrationJira {

    @Test
    public void postCreateIntegrationJira_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"apiToken\":" + "\"" + ApiTokenJira + "\"," +
                        "\"emailNotEmpty\":" + "\"" + true + "\"," +
                        "\"apiUrl\":" + "\"" + UrlJiraIntegration + "\"," +
                        "\"email\":" + "\"" + EmailJiraIntegration + "\"," +
                        "\"apiProvider\":" + "\"" + ApiProviderJira + "\"" +
                        "}")
                .when()
                .post(EndPoints.Integrations)
                .then()
                .statusCode(200)
                .and().body("apiToken", equalTo( EmailJiraIntegration + ":" + ApiTokenJira))
                .and().body("apiUrl", equalTo(UrlJiraIntegration))
                .and().body("apiProvider", equalTo(ApiProviderJira));
    }

    @Test
    public void postCreateIntegrationJira_status_401() {
        given()
                .spec(spec)
                .body("{" +
                        "\"apiToken\":" + "\"" + ApiTokenJira + "\"," +
                        "\"emailNotEmpty\":" + "\"" + true + "\"," +
                        "\"apiUrl\":" + "\"" + UrlJiraIntegration + "\"," +
                        "\"email\":" + "\"" + EmailJiraIntegration + "\"," +
                        "\"apiProvider\":" + "\"" + ApiProviderJira + "\"" +
                        "}")
                .when()
                .post(EndPoints.Integrations)
                .then()
                .statusCode(401);
    }

    @Test
    public void postCreateIntegrationJira_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"apiToken\":" + "\"" + ApiTokenJira + "\"," +
                        "\"emailNotEmpty\":" + "\"" + true + "\"," +
                        "\"apiUrl\":" + "\"" + UrlJiraIntegration + "\"," +
                        "\"email\":" + "\"" + EmailJiraIntegration + "\"," +
                        "\"apiProvider\":" + "\"" + ApiProviderJira + "\"" +
                        "}")
                .when()
                .post("/api/integrationss")
                .then()
                .statusCode(404);
    }
}
