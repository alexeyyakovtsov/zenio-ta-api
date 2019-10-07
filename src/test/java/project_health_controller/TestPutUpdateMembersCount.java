package project_health_controller;

import io.restassured.http.ContentType;
import org.junit.Test;

import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static TestSuite.SuiteTest.*;

public class TestPutUpdateMembersCount {

    @Test
    public void putUpdateMembersCount_status_200() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body("{" +
                                "\"membersCount\":" + "\"" + "1" + "\"" +
                        "}")
                .when()
                .put("/api/projects/" + Project_id + "/health" + "/members")
                .then()
                .statusCode(200);
    }

    @Test
    public void putUpdateMembersCount_status_401() {
        given()
                .baseUri(URL_Dev)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"membersCount\":" + "\"" + "1" + "\"" +
                        "}")
                .when()
                .put("/api/projects/" + Project_id + "/health" + "/members")
                .then()
                .statusCode(401);
    }

    @Test
    public void putUpdateMembersCount_status_404() {
        given()
                .baseUri(URL_Dev)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body("{" +
                        "\"membersCount\":" + "\"" + "1" + "\"" +
                        "}")
                .when()
                .put("/api/projectss/" + Project_id + "/health" + "/members")
                .then()
                .statusCode(404);
    }
}
