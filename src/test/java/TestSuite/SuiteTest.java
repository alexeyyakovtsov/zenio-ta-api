package TestSuite;

import io.restassured.http.Cookies;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import project_controller.*;
import user_controller.*;
import workspace_controller.*;

import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestGetAllUsers.class,
        TestGetCurrentUser.class,
        TestPostInviteUser.class,
        TestPostRestorePassword.class,

        TestGetWorkspace.class,
        //TestPostCreateWorkspace.class,
        TestGetWorkspaceId.class,
        TestPutUpdateWorkspace.class,
        TestGetWorkspaceMembers.class,

        TestPostCreateProject.class,
        TestGetUserProjects.class,
        TestPutUpdateProject.class,
        TestGetProjectsId.class,

        //TestDeleteProjectId.class
} )

public class SuiteTest {

    public static Cookies cookies;

    @BeforeClass
    public static void Login() {
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
}
