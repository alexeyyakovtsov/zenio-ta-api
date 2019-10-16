package TestSuite;

import activity_controller.*;
import area_controller.*;
import integration_controller.*;
import major_release_controller.*;
import minor_release_controller.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import project_controller.*;
import project_health_controller.*;
import story_controller.*;
import user_controller.*;
import workspace_controller.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.*;
import io.restassured.http.*;
import io.restassured.specification.RequestSpecification;
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
        TestPostCreateArea.class,
        TestPutUpdateArea.class,

        //Activity controller
        TestGetActivityId.class,
        TestPostCreateActivity.class,
        TestPutUpdateActivityId.class,

        //Story controller
        TestGetAllStories.class,
        TestPostCreateStory.class,
        TestPutUpdateStory.class,
        TestGetStoryId.class,
        TestGetDeletedStories.class,

        //Major release controller
        TestPostCreateMajorRelease.class,
        TestPutUpdateMajorRelease.class,

        //Minor Release
        TestGetMinorReleaseId.class,
        TestPostCreateMinorRelease.class,
        TestPutUpdateMinorRelease.class,

        //Integration controller
        TestGetAllIntegrationsProjects.class,
        TestGetIntegrations.class,
        TestPostCreateIntegrationPivotal.class,
        TestPostCreateIntegrationJira.class
} )

public class SuiteTest {

    public static Cookies cookies;
    public static RequestSpecification spec;

    @BeforeClass
    public static void Login() {
        spec = new RequestSpecBuilder()
                .setBaseUri(URL_Dev)
                .setBasePath("/api/")
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();

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
