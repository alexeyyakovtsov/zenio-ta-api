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
}
