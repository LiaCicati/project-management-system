package Mediator;

import Model.*;

import java.util.ArrayList;
import java.util.Collections;

public class ProjectManagementModelManager implements ProjectManagementModel
{
    private ProjectList projectList;
    private ProjectManagementPersistence file;

    public ProjectManagementModelManager()
    {
        this.projectList = new ProjectList();
    }

    @Override public TeamMember getTeamMemberByName(Name name)
    {
        for (Project project : projectList.getAllProjects())
        {
            for (TeamMember teamMember : project.getAllTeamMembers()
                .getAllTeamMembers())
            {
                if (teamMember.getName().equals(name))
                {
                    return teamMember;
                }
            }
        }
        return null;
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
        for (Project project : projectList.getAllProjects())
        {
            if (project.getTeamMember(teamMember).equals(teamMember))
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
        projectList.removeProject(project);
    }

    @Override public TeamMemberList getAllTeamMembers(Project project)
    {
        return project.getAllTeamMembers();
    }

    @Override public TaskList getAllTasks(Requirement requirement)
    {
        return requirement.getAllTasks();
    }

    @Override public RequirementList getAllRequirements(Project project)
    {
        return project.getAllRequirements();
    }

    @Override public ProjectList getAllProjects()
    {
        return projectList;
    }

    @Override public Project getProject(String title)
    {
        return projectList.getProjectByTitle(title);
    }

    @Override public void reorderRequirements(Project project, int position,
        int newPosition)
    {
        project.getAllRequirements().reorder(position, newPosition);
    }

    @Override public int getNumberOfTasks(Requirement requirement)
    {
        return requirement.countTasks();
    }

    @Override public int getNumberOfRequirements(Project project)
    {
        return project.getNumberOfRequirements();
    }

    @Override public int getNumberOfProjects()
    {
        return projectList.getNumberOfProjects();
    }

    @Override public TeamMember get(Project project, int index)
    {
        return project.getAllTeamMembers().get(index);
    }

    @Override public TeamMember getTeamMemberById(Project project, int ID)
    {
        return project.getAllTeamMembers().getTeamMemberById(ID);
    }
}