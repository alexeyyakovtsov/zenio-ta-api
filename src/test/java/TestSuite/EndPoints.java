package TestSuite;

import static parameters.Configurations.*;

public class EndPoints {
    public static String
            GetActivityId = "/api/projects/" + Project_id + "/activities/" + ActivityId,
            Activity = "/api/projects/" + Project_id + "/activities",

            GetAreaId = "/api/projects/" + Project_id + "/areas/" + AreaId,
            Area = "/api/projects/" + Project_id + "/areas",

            GetAllIntegrations = "/api/integrations/projects",
            Integrations = "/api/integrations",

            PostCreateMajorRelease = "/api/projects/" + Project_id + "/releases/major",
            PutUpdateMajorRelease = "/api/projects/" + Project_id + "/releases/major/" + MajorRelease,

            GetMinorReleaseId = "/api/projects/" + Project_id + "/releases/minor/" + MinorRelease,
            CreateMinorRelease = "/api/projects/" + Project_id + "/releases/minor",

            DeleteProjectId = "/api/projects/" + Project_deleted_id,
            GetProjectIdUser = "/api/projects/" +  Project_id + "/users",
            GetProjectId = "/api/projects/" + Project_id,
            UserProjects = "/api/projects",

            GetProjectHealth = "/api/projects/" + Project_id + "/health",
            PutUpdateMembersCount = "/api/projects/" + Project_id + "/health" + "/members",

            AllStories = "/api/projects/" + Project_id + "/stories",
            GetDeletedStories = "/api/projects/" + Project_id + "/stories/deleted",
            GetStoryId = "/api/projects/" + Project_id + "/stories/" + StoryId,

            GetAllUsers = "/api/users",
            GetCurrentUser = "/api/users/me",
            InviteUser = "/api/users/invite",
            RestorePassword = "/api/users/restore",

            Workspaces = "/api/workspaces",
            GetWorkspaceId = "/api/workspaces/" + Workspace_update_id,
            GetWorkspaceMembers = "/api/workspaces/" + Workspace_id + "/users",
            UpdateWorkspaceId = "/api/workspaces/" + Workspace_update_id;
}
