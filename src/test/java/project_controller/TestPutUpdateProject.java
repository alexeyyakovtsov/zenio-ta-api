package project_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static TestSuite.SuiteTest.*;

public class TestPutUpdateProject {

    @Test
    public void putUpdateProject_status200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"id\":" + "\"" + Project_update_id + "\"," +
                        "\"name\":" + "\"" + ProjectName + "\"" +
                        "}")
                .when()
                .put("/api/projects")
                .then()
                .statusCode(200)
                .and().body("id", equalTo(Project_update_id))
                .and().body("workspaceId", equalTo(4))
                .and().body("deleted", equalTo(false))
                .and().body("ownerId", equalTo(1));
    }

    @Test
    public void putUpdateProject_status401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"id\":" + "\"" + Project_update_id + "\"," +
                        "\"name\":" + "\"" + ProjectName + "\"" +
                        "}")
                .when()
                .put("/api/projects")
                .then()
                .statusCode(401);
    }

    @Test
    public void putUpdateProject_status404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"id\":" + "\"" + Project_update_id + "\"," +
                        "\"name\":" + "\"" + ProjectName + "\"" +
                        "}")
                .when()
                .put("/api/projectts")
                .then()
                .statusCode(404);
    }
}
