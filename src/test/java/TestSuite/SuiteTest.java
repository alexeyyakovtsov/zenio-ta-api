package TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import project_controller.*;
import user_controller.*;
import workspace_controller.*;

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

        TestGetUserProjects.class,
        TestPostCreateProject.class,
        TestPutUpdateProject.class,
        TestGetProjectsId.class,
        //TestDeleteProjectId.class
} )

public class SuiteTest {


}
