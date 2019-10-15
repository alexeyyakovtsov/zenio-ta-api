package TestSuite;

import static parameters.Configurations.*;

public class EndPoints {
    public static String
            GetActivityId = "projects/" + Project_id + "/activities/" + ActivityId,
            Activity = "projects/" + Project_id + "/activities",

            GetAreaId = "projects/" + Project_id + "/areas/" + AreaId,
            Area = "projects/" + Project_id + "/areas",

            GetAllIntegrations = "integrations/projects",
            Integrations = "integrations",

            PostCreateMajorRelease = "projects/" + Project_id + "/releases/major",
            PutUpdateMajorRelease = "projects/" + Project_id + "/releases/major/" + MajorRelease,

            GetMinorReleaseId = "projects/" + Project_id + "/releases/minor/" + MinorRelease,
            CreateMinorRelease = "projects/" + Project_id + "/releases/minor",

            DeleteProjectId = "projects/" + Project_deleted_id,
            GetProjectIdUser = "projects/" +  Project_id + "/users",
            GetProjectId = "projects/" + Project_id,
            UserProjects = "projects",

            GetProjectHealth = "projects/" + Project_id + "/health",
            PutUpdateMembersCount = "projects/" + Project_id + "/health" + "/members",

            AllStories = "projects/" + Project_id + "/stories",
            GetDeletedStories = "projects/" + Project_id + "/stories/deleted",
            GetStoryId = "projects/" + Project_id + "/stories/" + StoryId,

            GetAllUsers = "users",
            GetCurrentUser = "users/me",
            InviteUser = "users/invite",
            RestorePassword = "users/restore",

            Workspaces = "workspaces",
            GetWorkspaceId = "workspaces/" + Workspace_update_id,
            GetWorkspaceMembers = "workspaces/" + Workspace_id + "/users",
            UpdateWorkspaceId = "workspaces/" + Workspace_update_id;
}
