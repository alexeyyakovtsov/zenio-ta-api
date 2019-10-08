package parameters;

import org.apache.commons.lang3.RandomStringUtils;

public class Configurations {

    private static String randomString() {
        return (RandomStringUtils.randomAlphabetic(12));
    }

    public static String
        URL_Dev = "https://dev.zenio.co",

        User_restore_password_email = "alexey.yakovtsov@mail.ru",

        Workspace_update_id = "27",
        Workspace_id = "4",

        email = randomString() + "@gmail.com",
        WorkspaceName = randomString(),
        ProjectName = randomString(),
        BodyEmail = ("{\"emails\":" + "[\"" + email + "\"]}"),
        WorkspaceNew = ("{\"name\":" + "\"" + WorkspaceName + "\"}"),

        Checksum = randomString(),

        AreaName = randomString(),
        ActivityName = randomString(),
        StoryName = randomString(),
        Description = randomString(),
        MajorReleaseName = randomString(),
        MinorReleaseName = randomString();

    public static int
            Project_update_id = 16,
            Project_id = 31,
            Project_deleted_id = 586,

            AreaId = 67,
            ActivityId = 1053,
            MajorRelease = 2216,
            MinorRelease = 6200,
            StoryId = 6199;
}
