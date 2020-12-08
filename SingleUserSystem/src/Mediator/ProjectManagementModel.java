package Mediator;

import Model.*;

public interface ProjectManagementModel
{
  public TeamMemberList getTeamMemberByName(Name name);

  public void addTeamMember(TeamMember teamMember);

  public void removeTeamMember(TeamMember teamMember);

  public void removeTeamMemberFromRequirement(Requirement requirement,TeamMember teamMember);

  public void addTaskToRequirement(Requirement requirement,Task task);

  public void removeTaskFromRequirement(Requirement requirement,Task task);

  public void addRequirementToProject(Project project,Requirement requirement);

  public void removeRequirementFromProject( Project project,Requirement requirement);

  public void addProject(Project project);

  public void removeProject(Project project);

  public TeamMemberList getAllTeamMembers(TeamMemberList teamMembers);

  public TaskList getAllTasks(TaskList tasks);

  public RequirementList getAllRequirements(RequirementList requirements);

  public ProjectList getAllProjects(ProjectList projects);

  public Project getProject(String title);

  public void reorder(int position, int newPosition);

  public TeamMember addTeamMember(Name name,String role);

  public int getSize();

  public TeamMember get(int index);

}
