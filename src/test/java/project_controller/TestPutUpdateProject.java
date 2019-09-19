package project_controller;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static parameters.Configurations.*;

public class TestPutUpdateProject {

    private static Cookies cookies;

    @Before
    public void Login() {
        cookies = given()
                .baseUri(URL_Dev)
                .urlEncodingEnabled(true)
                .param("email", "zenio@zensoft.io")
                .param("password", "12345678")
                .when()
                .post("/login")
                .then()
                .statusCode(302)
                .extract()
                .response()
                .getDetailedCookies();
    }

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
                .and().body("id" ,equalTo(Project_update_id ))
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
