package Mediator;

import Model.*;

import java.util.ArrayList;
import java.util.Collections;

public class ProjectManagementModelManager implements ProjectManagementModel
{
  private ProjectList projectList;
  private TeamMemberList teamMemberList;
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

  @Override public void addTeamMember(TeamMember teamMember)
  {
    for (Project project : projectList.getAllProjects())
    {
      if (project.getTeamMember(teamMember).equals(teamMember))
      {
        project.addTeamMember(teamMember);
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

  @Override public void addTaskToRequirement(Requirement requirement, Task task)
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
      int requirementID)
  {
    for (Project projectTemp : projectList.getAllProjects())
    {
      if (projectTemp.equals(project))
      {
        projectTemp.removeRequirement(requirementID);
      }
    }
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
//
//  @Override public int getNumberOfTeamMembers()
//  {
//    return teamMemberList.getSize();
//  }

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

//  @Override public TeamMember getTeamMemberById(int ID)
//  {
//    for(int i=0;i<teamMemberList.getSize();i++)
//    {
//      if(teamMemberList.get(i).getId()==ID)
//      {
//        return teamMemberList.get(i);
//      }
//    }
//    return null;
//  }

  @Override public void editTask(Task task, String title, String description,
      double estimatedTime, TeamMember responsibleTeamMember, MyDate deadline)
  {
    task.editTask(title, description, estimatedTime, responsibleTeamMember,
        deadline);
  }

  @Override public void editRequirement(Requirement requirement, int ID,
      double estimatedTime, TeamMember responsibleTeamMember, MyDate deadline)
  {
    requirement
        .editRequirement(ID, estimatedTime, responsibleTeamMember, deadline);
  }

  @Override public void changeStatus(Project project, String status)
  {
    project.changeStatus(status);
  }
  
  @Override  public void changeRole(TeamMember teamMember,String role)
  {
    teamMember.changeRole(role);
  }

  @Override public void editProject(Project project, String title,
      int customerID, String description, MyDate deadline, String status)
  {
    project.editProject(title, customerID, description, deadline);
    project.changeStatus(status);
  }

  public Project getProject(int index)
  {
    return projectList.getProject(index);
  }

  @Override public Project getProjectByID(int id) {
    return projectList.getProjectById(id);
  }

  @Override public TeamMemberList  getTeamMembers() {
    return teamMemberList;
  }

  public  int getNumberOfTeamMembers() {
    return teamMemberList.getSize();
  }

  public TeamMember getTeamMemberById(int ID) {
    return teamMemberList.getTeamMemberById(ID);
  }
  
//   @Override public Requirement getRequirement(int index)
//  {
//    return requirementList.getRequirement(index);
//  }
//
//  @Override public Requirement getRequirementByID(int id)
//  {
//    for(int i=0;i<requirementList.getSize();i++)
//    {
//      if(requirementList.getRequirement(i).getID()==id)
//      {
//        return requirementList.getRequirement(i);
//      }
//    }
//    return null;
//  }
}
