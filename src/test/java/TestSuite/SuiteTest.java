package TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import user_controller.TestGetAllUsers;
import user_controller.TestGetCurrentUser;
import user_controller.TestPostInviteUser;
import user_controller.TestPostRestorePassword;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestGetAllUsers.class, TestGetCurrentUser.class, TestPostInviteUser.class, TestPostRestorePassword.class} )

public class SuiteTest {


}
