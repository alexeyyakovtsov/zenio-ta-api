package TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import project_controller.TestGetUserProjects;
import project_controller.TestPostCreateProject;
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
        TestPostCreateProject.class
} )

public class SuiteTest {


}
