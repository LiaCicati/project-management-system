package Mediator;

import Model.*;

import java.util.ArrayList;
import java.util.Collections;

public class ProjectManagementModelManager
{
  private ProjectList projectList;
  private RequirementList requirementList;
  private TaskList taskList;
  private TeamMemberList teamMemberList;
  private  ProjectManagementPersistence file;

  public ProjectManagementModelManager()
  {
    this.projectList = new ProjectList();
    this.requirementList = new RequirementList();
    this.taskList = new TaskList();
    this.teamMemberList = new TeamMemberList();
  }

  public TeamMember getTeamMemberByName(Name name)
  {
    for(int i=0;i<teamMemberList.getSize();i++)
    {
      if(teamMemberList.get(i).getName().equals(name))
      {
        return teamMemberList.get(i);
      }
    }
    return null;
  }

  public void addTeamMember(TeamMember teamMember)
  {
    teamMemberList.addTeamMember(teamMember);
  }

  public void editTeamMember(Name name,String role)
  {
    for(int i=0;i<teamMemberList.getSize();i++)
    {
      if(teamMemberList.get(i).getName().equals(name))
      {
        teamMemberList.get(i).getRole().equals(role);
      }
    }
  }


  public void removeTeamMember(TeamMember teamMember)
  {
    teamMemberList.removeTeamMember(teamMember);
  }

  public void addTaskToRequirement(Requirement requirement,Task task)
  {
    requirement.getAllTasks().add(task);
  }

  public void removeTaskFromRequirement(Requirement requirement,Task task)
  {
    requirement.getAllTasks().remove(task);
  }

  public void addRequirementToProject(Project project,Requirement requirement)
  {
    project.getAllRequirements().add(requirement);
  }

  public void removeRequirementFromProject( Project project,Requirement requirement)
  {
    project.getAllRequirements().remove(requirement);
  }

  public void addProject(Project project)
  {
    projectList.addProject(project);
  }

  public void removeProject(Project project)
  {
    projectList.removeProject(project);
  }

  public void deleteTask(Task task)
  {
    taskList.removeTask(task);
  }

  public ArrayList<TeamMember> getAllTeamMembers(Project project)
  {
    return project.getAllTeamMembers();
  }

  public ArrayList<Task> getAllTasks(Requirement requirement)
  {
    return requirement.getAllTasks();
  }

  public ArrayList<Requirement> getAllRequirements(Project project)
  {
    return project.getAllRequirements();
  }

  public ProjectList getAllProjects()
  {
    return projectList;
  }

  public Project getProject(String title)
  {
    return projectList.getProjectByTitle(title);
  }

//  public void reorder(int position, int newPosition)
//  {
//    try
//    {
//      Collections.swap(requirements, position, newPosition);
//    }
//    catch (IndexOutOfBoundsException e)
//    {
//      e.printStackTrace();
//    }
//  }

  public int getSizeOfTask(Requirement requirement,Task task)
  {
    return requirement.getAllTasks().size();
  }

  public int getSizeOfRequirement(Project project,Requirement requirement)
  {
    return project.getAllRequirements().size();
  }

  public int getSizeOfProject(Project project)
  {
    return projectList.getAllProjects().size();
  }

  public TeamMember get(Project project,int index)
  {
    return project.getAllTeamMembers().get(index);
  }

  public TeamMember getTeamMemberById(Project project,int ID)
  {
    return project.getTeamMemberByID(ID);
  }
}
