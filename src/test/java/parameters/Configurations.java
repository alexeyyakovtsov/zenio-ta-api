package parameters;

import org.apache.commons.lang3.RandomStringUtils;

public class Configurations {


    public static String
        URL_Dev = "https://dev.zenio.co",
        URL_Dev_Login = "https://dev.zenio.co/login",

        User_restore_password_email = "alexey.yakovtsov@mail.ru",

        Workspace_update_id = "27",
        Workspace_id = "4",

        Workspace_name = "Test QA Workspace";


    public static int Project_update_id = 16;
    public static int Project_id = 31;
    public static int Project_deleted_id = 586;

    private static String randomString() {
        return (RandomStringUtils.randomAlphabetic(12));
    }

    public static String email = randomString() + "@gmail.com";
    private static String WorkspaceName = randomString();
    public static String ProjectName = randomString();

    public static String BodyEmail = ("{\"emails\":" + "[\"" + email + "\"]}");
    public static String WorkspaceNew = ("{\"name\":" + "\"" + WorkspaceName + "\"}");
}
