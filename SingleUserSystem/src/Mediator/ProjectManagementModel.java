package Mediator;

import Model.*;

public interface ProjectManagementModel
{
  public TeamMember getTeamMemberByName(Name name);

  public void addTeamMember(TeamMember teamMember);

  public TeamMember editTeamMember(Name name,String role);

  public void removeTeamMember(TeamMember teamMember);

  public void addTaskToRequirement(Requirement requirement,Task task);

  public void removeTaskFromRequirement(Requirement requirement,Task task);

  public void addRequirementToProject(Project project,Requirement requirement);

  public void removeRequirementFromProject( Project project,Requirement requirement);

  public void addProject(Project project);

  public void removeProject(Project project);

  public TeamMemberList getAllTeamMembers(Project project);

  public TaskList getAllTasks(Requirement requirement);

  public RequirementList getAllRequirements(Project project);

  public ProjectList getAllProjects(ProjectList projects);

  public Project getProject(String title);

  public void reorderRequirememnts(Project project,int position, int newPosition);

  public int getNumberOfTasks(Requirement requirement);

  public int getNumberOfRequirements(Project project);

  public int getNumberOfProjects();

  public TeamMember get(Project project,int index);

  public TeamMember getTeamMemberById(Project project,int ID);

}
