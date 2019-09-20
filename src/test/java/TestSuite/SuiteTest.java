package TestSuite;

import area_controller.TestGetAreaId;
import area_controller.TestPostCreateArea;
import io.restassured.http.Cookies;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import project_controller.*;
import project_health_controller.*;
import user_controller.*;
import workspace_controller.*;

import static io.restassured.RestAssured.given;
import static parameters.Configurations.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        //User controller
        TestGetAllUsers.class,
        TestGetCurrentUser.class,
        TestPostInviteUser.class,
        TestPostRestorePassword.class,

        //Workspace controller
        TestGetWorkspace.class,
        //TestPostCreateWorkspace.class,
        TestGetWorkspaceId.class,
        TestPutUpdateWorkspace.class,
        TestGetWorkspaceMembers.class,

        //Project controller
        TestPostCreateProject.class,
        TestGetUserProjects.class,
        TestPutUpdateProject.class,
        TestGetProjectsId.class,
        //TestDeleteProjectId.class
        TestGetProjectIdUser.class,

        //Project Health controller
        TestGetProjectIdHealth.class,
        TestPutUpdateMembersCount.class,

        //Area controller
        TestGetAreaId.class,
        TestPostCreateArea.class
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
