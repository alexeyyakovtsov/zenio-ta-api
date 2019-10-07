package TestSuite;

import activity_controller.TestGetActivityId;
import activity_controller.TestPostCreateActivity;
import activity_controller.TestPutUpdateActivityId;
import area_controller.TestGetAreaId;
import area_controller.TestPostCreateArea;
import area_controller.TestPutUpdateArea;
import io.restassured.http.Cookies;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.Suite;
import project_controller.*;
import project_health_controller.*;
import story_controller.TestGetAllStories;
import story_controller.TestPostCreateStory;
import story_controller.TestPutUpdateStory;
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
        //TestPutUpdateProject.class,
        TestGetProjectsId.class,
        //TestDeleteProjectId.class
        TestGetProjectIdUser.class,

        //Project Health controller
        TestGetProjectIdHealth.class,
        TestPutUpdateMembersCount.class,

        //Area controller
        TestGetAreaId.class,
        TestPostCreateArea.class,
        TestPutUpdateArea.class,

        //Activity controller
        TestGetActivityId.class,
        TestPostCreateActivity.class,
        //TestPutUpdateActivityId.class

        //Story controller
        TestGetAllStories.class,
        TestPostCreateStory.class
        //TestPutUpdateStory.class
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
