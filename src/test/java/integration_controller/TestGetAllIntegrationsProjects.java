package integration_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static TestSuite.SuiteTest.*;

public class TestGetAllIntegrationsProjects {

    @Test
    public void getAllIntegrationsProjects_status_200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/integrations/projects")
                .then()
                .statusCode(200)
                .and().body("integrationId",hasItems(412, 177, 544));
    }

    @Test
    public void getAllIntegrationsProjects__status_401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/integrations/projects")
                .then()
                .statusCode(401);
    }

    @Test
    public void getAllIntegrationsProjects__status_404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .get("/api/integrationss/projects")
                .then()
                .statusCode(404);
    }
}
