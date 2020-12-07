package Mediator;

import Model.*;

import javax.swing.*;

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

  public void addProject(Project project)
  {
    projectList.addProject(project);
  }

  public void addRequirement(Requirement requirement)
  {
    requirementList.addRequirement(requirement);
  }

  public void addTask(Task task)
  {
    taskList.addTask(task);
  }

  public void addTeamMember(TeamMember teamMember)
  {
    teamMemberList.addTeamMember(teamMember);
  }

  public void deleteRequirement(Requirement requirement)
  {
    requirementList.removeRequirement(requirement);
  }

  public void deleteTask(Task task)
  {
    taskList.removeTask(task);
  }

  public void deleteTeamMember(TeamMember teamMember)
  {
    teamMemberList.removeTeamMember(teamMember);
  }

  public ProjectList getAllProjects()
  {
    return projectList;
  }

  public TeamMemberList getAllTeamMembers()
  {
    return teamMemberList;
  }

  public RequirementList getAllRequirements()
  {
    return requirementList;
  }

  public TaskList getAllTasks()
  {
    return taskList;
  }

  public Project getProject(String title)
  {
    return projectList.getProjectByTitle(title);
  }

  //public TeamMemberList getTeamMember(String role)  (this method is in the diagram,but i think we don't need it anymore)
}
