package Mediator;

import Model.*;

import java.util.ArrayList;
import java.util.Collections;

public class ProjectManagementModelManager implements ProjectManagementModel
{
    private ProjectList projectList;
    private RequirementList requirementList;
    private TaskList taskList;
    private TeamMemberList teamMemberList;
    private ProjectManagementPersistence file;

    public ProjectManagementModelManager()
    {
        this.projectList = new ProjectList();
        this.requirementList = new RequirementList();
        this.taskList = new TaskList();
        this.teamMemberList = new TeamMemberList();
    }

    @Override public TeamMember getTeamMemberByName(Name name)
    {
        return teamMemberList.getTeamMemberByName(name);
    }

    @Override public void addTeamMemberToProject(Project project,
        TeamMember teamMember)
    {
        for (Project projectTemp : projectList.getAllProjects())
        {
            if (projectTemp.equals(project))
            {
                projectTemp.addTeamMember(teamMember);
            }
        }
    }

    @Override public TeamMember editTeamMember(Name name, String role)
    {
        return null;
    }

    @Override public void removeTeamMember(TeamMember teamMember)
    {
        //don't think we need this line anymore???
        teamMemberList.removeTeamMember(teamMember);

        for (Project project : projectList.getAllProjects())
        {
            if (project.getTeamMember(teamMember)
                .equals(teamMember))
            {
                project.removeTeamMember(teamMember);
            }
        }
    }

    @Override public void addTaskToRequirement(Requirement requirement,
        Task task)
    {
        for (Project project : projectList.getAllProjects())
        {
            for (Requirement requirementTest : project.getAllRequirements()
                .getRequirements())
            {
                if (requirementTest.equals(requirement))
                {
                    requirementTest.addTask(task);
                }
            }
        }
    }

    @Override public void removeTaskFromRequirement(Requirement requirement,
        Task task)
    {
        for (Project project : projectList.getAllProjects())
        {
            for (Requirement requirementTest : project.getAllRequirements()
                .getRequirements())
            {
                if (requirementTest.equals(requirement))
                {
                    requirementTest.removeTask(task);
                }
            }
        }
    }

    @Override public void addRequirementToProject(Project project,
        Requirement requirement)
    {
        for (Project projectTemp : projectList.getAllProjects())
        {
            if (projectTemp.equals(project))
            {
                projectTemp.addRequirement(requirement);
            }
        }
    }

    @Override public void removeRequirementFromProject(Project project,
        Requirement requirement)
    {

    }

    @Override public void addProject(Project project)
    {
        projectList.addProject(project);
    }

    @Override public void removeProject(Project project)
    {

    }

    @Override public TeamMemberList getAllTeamMembers(Project project)
    {
        return null;
    }

    @Override public TaskList getAllTasks(Requirement requirement)
    {
        return null;
    }

    @Override public RequirementList getAllRequirements(Project project)
    {
        return null;
    }

    @Override public ProjectList getAllProjects(ProjectList projects)
    {
        return null;
    }

    @Override public Project getProject(String title)
    {
        return null;
    }

    @Override public void reorderRequirements(Project project, int position,
        int newPosition)
    {

    }

    @Override public int getNumberOfTasks(Requirement requirement)
    {
        return 0;
    }

    @Override public int getNumberOfRequirements(Project project)
    {
        return 0;
    }

    @Override public int getNumberOfProjects()
    {
        return 0;
    }

    @Override public TeamMember get(Project project, int index)
    {
        return null;
    }

    @Override public TeamMember getTeamMemberById(Project project, int ID)
    {
        return null;
    }
}
