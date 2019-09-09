package parameters;

import org.apache.commons.lang3.RandomStringUtils;

public class Configurations {


    public static String
        URL_Dev = "https://dev.zenio.co",
        URL_Dev_API = "https://dev.zenio.co/api",
        URL_Dev_Login = "https://dev.zenio.co/login",

        User_restore_password_email = "alexey.yakovtsov@mail.ru",

        Workspace_name = "Test QA Workspace";

    public static String randomString() {
        return (RandomStringUtils.randomAlphabetic(12));
    }

    public static String email = randomString() + "@gmail.com";
    public static String WorkspaceName = randomString();
    public static String BodyEmail = ("{\"emails\":" + "[\"" + email + "\"]}");
    public static String WorkspaceNew = ("{\"name\":" + "\"" + WorkspaceName + "\"}");
}
