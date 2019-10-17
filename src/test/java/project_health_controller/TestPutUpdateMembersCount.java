package project_health_controller;

import TestSuite.EndPoints;
import org.junit.Test;
import static parameters.Configurations.*;
import static io.restassured.RestAssured.given;
import static TestSuite.SuiteTest.*;

public class TestPutUpdateMembersCount {

    @Test
    public void putUpdateMembersCount_status_200() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"membersCount\":" + "\"" + "1" + "\"" +
                        "}")
                .when()
                .put(EndPoints.PutUpdateMembersCount)
                .then()
                .statusCode(200);
    }

    @Test
    public void putUpdateMembersCount_status_401() {
        given()
                .spec(spec)
                .body("{" +
                        "\"membersCount\":" + "\"" + "1" + "\"" +
                        "}")
                .when()
                .put(EndPoints.PutUpdateMembersCount)
                .then()
                .statusCode(401);
    }

    @Test
    public void putUpdateMembersCount_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .body("{" +
                        "\"membersCount\":" + "\"" + "1" + "\"" +
                        "}")
                .when()
                .put("/api/projectss/" + Project_id + "/health" + "/members")
                .then()
                .statusCode(404);
    }
}
