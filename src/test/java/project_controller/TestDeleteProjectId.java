package project_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;
import static TestSuite.SuiteTest.*;

public class TestDeleteProjectId {

    @Test
    public void deleteProjectId_status200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .delete("/api/projects/" + Project_deleted_id)
                .then()
                .statusCode(204);
    }

    @Test
    public void deleteProjectId_status401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .when()
                .delete("/api/projects" + Project_deleted_id)
                .then()
                .statusCode(401);
    }

    @Test
    public void deleteProjectId_status404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .delete("/api/projectts" + Project_deleted_id)
                .then()
                .statusCode(404);
    }
}
