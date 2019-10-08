package integration_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestPostCreateIntegrationPivotal {

    @Test
    public void postCreateIntegrationPivotal_status_200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"apiToken\":" + "\"" + ApiTokenPivotal + "\"," +
                        "\"apiUrl\":" + "\"" + UrlPivotalIntegration+ "\"," +
                        "\"apiProvider\":" + "\"" + ApiProviderPivotal + "\"" +
                        "}")
                .when()
                .post("/api/integrations")
                .then()
                .statusCode(200)
                .and().body("apiToken", equalTo(ApiTokenPivotal))
                .and().body("apiUrl", equalTo(UrlPivotalIntegration))
                .and().body("apiProvider", equalTo(ApiProviderPivotal));
    }

    @Test
    public void postCreateIntegrationPivotal_status_401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"apiToken\":" + "\"" + ApiTokenPivotal + "\"," +
                        "\"apiUrl\":" + "\"" + UrlPivotalIntegration+ "\"," +
                        "\"apiProvider\":" + "\"" + ApiProviderPivotal + "\"" +
                        "}")
                .when()
                .post("/api/integrations")
                .then()
                .statusCode(401);
    }

    @Test
    public void postCreateIntegrationPivotal_status_404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
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
