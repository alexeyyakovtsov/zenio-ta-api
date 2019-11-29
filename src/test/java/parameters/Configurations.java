package parameters;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class Configurations {

    static Faker faker = new Faker();

    private static String randomString() {
        return (RandomStringUtils.randomAlphabetic(12));
    }

    public static String
        URL_Dev = "https://dev.zenio.co",

        User_restore_password_email = "alexey.yakovtsov@mail.ru",

        fake_email = faker.internet().emailAddress(),
        fake_workspace_name = faker.app().name(),
        fake_name = faker.app().name(),

        ProjectName = faker.app().name(),
        ProjectUpdateName = faker.app().name() + " Update name",
        BodyEmail = ("{\"emails\":" + "[\"" + fake_email + "\"]}"),
        WorkspaceNew = ("{\"name\":" + "\"" + fake_workspace_name + "\"}"),

        ApiTokenPivotal = "3901cf4de092d5cbe830d88f977ee565",
        ApiTokenJira = "ZwapUqRrCnWXbzXZKJRQFEC6",
        EmailJiraIntegration = "alexey.yakovtsov@zenio.co",
        UrlJiraIntegration = "https://zenio.atlassian.net/",
        UrlPivotalIntegration = "https://www.pivotaltracker.com/services/v5/",
        ApiProviderPivotal = "PIVOTAL",
        ApiProviderJira = "JIRA",

        Checksum = randomString(),

        Description = faker.chuckNorris().fact();

    public static int
            Workspace_update_id = 27,
            Workspace_id = 4,

            Project_update_id = 1460,
            Project_id = 31,
            Project_deleted_id = 586,

            AreaId = 67,
            ActivityId = 1053,
            MajorRelease = 2216,
            MinorRelease = 6200,
            StoryId = 6199;
}
