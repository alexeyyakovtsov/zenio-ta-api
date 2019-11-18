package story_controller;

import TestSuite.EndPoints;
import TestSuite.SuiteTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

public class TestGetAllStories extends SuiteTest {

    @Test
    @DisplayName("GET All Stories status = 200")
    public void getAllStories_status_200() {

        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get(EndPoints.AllStories)
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("GET All Stories status = 401")
    public void getAllStories_status_401() {
        given()
                .spec(spec)
                .when()
                .get(EndPoints.AllStories)
                .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("GET All Stories status = 404")
    public void getAllStories_status_404() {
        given()
                .spec(spec)
                .cookies(cookies)
                .when()
                .get("/api/projects/" + Project_id + "/storiess")
                .then()
                .statusCode(404);
    }
}
