package integration_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestPostCreateIntegrationJira extends SuiteTest {

    @Test
    @DisplayName("POST Create JIRA Integrations status = 200")
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
                .statusCode(201)
                .and().body("apiToken", equalTo( EmailJiraIntegration + ":" + ApiTokenJira))
                .and().body("apiUrl", equalTo(UrlJiraIntegration))
                .and().body("apiProvider", equalTo(ApiProviderJira));
    }

    @Test
    @DisplayName("POST Create JIRA Integrations status = 401")
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
    @DisplayName("POST Create JIRA Integrations status = 404")
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

    @Test
    @DisplayName("POST Negative test 1 status = 400")
    public void postNegativeTest1_status_400(){
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"emailNotEmpty\":" + "\"" + true + "\"," +
                        "\"apiUrl\":" + "\"" + UrlJiraIntegration + "\"," +
                        "\"email\":" + "\"" + EmailJiraIntegration + "\"," +
                        "\"apiProvider\":" + "\"" + ApiProviderJira + "\"" +
                        "}")
                .when()
                .post(EndPoints.Integrations)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative test 2 status = 400")
    public void postNegativeTest2_status_400(){
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"apiToken\":" + "\"" + ApiTokenJira + "\"," +
                        "\"emailNotEmpty\":" + "\"" + true + "\"," +
                        "\"email\":" + "\"" + EmailJiraIntegration + "\"," +
                        "\"apiProvider\":" + "\"" + ApiProviderJira + "\"" +
                        "}")
                .when()
                .post(EndPoints.Integrations)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative test 3 status = 400")
    public void postNegativeTest3_status_400(){
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"apiToken\":" + "\"" + ApiTokenJira + "\"," +
                        "\"emailNotEmpty\":" + "\"" + true + "\"," +
                        "\"apiUrl\":" + "\"" + UrlJiraIntegration + "\"," +
                        "\"email\":" + "\"" + EmailJiraIntegration + "\"," +
                        "}")
                .when()
                .post(EndPoints.Integrations)
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST Negative test 4 status = 400")
    public void postNegativeTest4_status_400(){
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"apiToken\":" + "\"" + ApiTokenJira + "\"," +
                        "\"emailNotEmpty\":" + "\"" + true + "\"," +
                        "\"apiUrl\":" + "\"" + UrlJiraIntegration + "\"," +
                        "\"email\":" + "\"" + EmailJiraIntegration + "\"," +
                        "\"apiProvider\":" + "\"" + "QATest123" + "\"" +
                        "}")
                .when()
                .post(EndPoints.Integrations)
                .then()
                .statusCode(400);
    }
}
