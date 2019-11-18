package integration_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;;
import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

public class TestPostCreateIntegrationPivotal extends SuiteTest {

    @Test
    @DisplayName("POST Create PIVOTAL Integrations status = 200")
    public void postCreateIntegrationPivotal_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"apiToken\":" + "\"" + ApiTokenPivotal + "\"," +
                        "\"apiUrl\":" + "\"" + UrlPivotalIntegration+ "\"," +
                        "\"apiProvider\":" + "\"" + ApiProviderPivotal + "\"" +
                        "}")
                .when()
                .post(EndPoints.Integrations)
                .then()
                .statusCode(201)
                .and().body("apiToken", equalTo(ApiTokenPivotal))
                .and().body("apiUrl", equalTo(UrlPivotalIntegration))
                .and().body("apiProvider", equalTo(ApiProviderPivotal));
    }

    @Test
    @DisplayName("POST Create PIVOTAL Integrations status = 401")
    public void postCreateIntegrationPivotal_status_401() {
        given()
                .spec(spec)
                .body("{" +
                        "\"apiToken\":" + "\"" + ApiTokenPivotal + "\"," +
                        "\"apiUrl\":" + "\"" + UrlPivotalIntegration+ "\"," +
                        "\"apiProvider\":" + "\"" + ApiProviderPivotal + "\"" +
                        "}")
                .when()
                .post(EndPoints.Integrations)
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("POST Create PIVOTAL Integrations status = 404")
    public void postCreateIntegrationPivotal_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"apiToken\":" + "\"" + ApiTokenPivotal + "\"," +
                        "\"apiUrl\":" + "\"" + UrlPivotalIntegration+ "\"," +
                        "\"apiProvider\":" + "\"" + ApiProviderPivotal + "\"" +
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
