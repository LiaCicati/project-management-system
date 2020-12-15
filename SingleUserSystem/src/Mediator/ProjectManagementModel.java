package Mediator;

import Model.*;

public interface ProjectManagementModel
{
  TeamMember getTeamMemberByName(Name name);

  void addTeamMember(int projectID, TeamMember teamMember);

  void editTeamMember(int projectID, int ID, TeamMember teamMember,
      String role);

  void removeTeamMember(TeamMember teamMember);
  void removeTeamMemberFromTask(Task task, TeamMember teamMember);
  TeamMemberList getAllTeam(Project project, Requirement requirement,
      Task task);
  void addTask(int requirementID, int projectID, Task task);
  void addTaskToRequirement(Requirement requirement, Task task);

  void removeTaskFromRequirement(Requirement requirement, Task task);

  void addRequirement(int projectID, Requirement requirement);
  void editTask(Task task, int taskID, int projectID, int requirementID,
      String status);
  TeamMember getAllTeamMembers(int projectID, int requirementID, int taskID,
      int teamMemberID);

  void editRequirement(int projectID, int ID, Requirement requirement,
      String status);

  void removeRequirementFromProject(Project project, int requirementID);

  void addProject(Project project, String title, int ID);

  void removeProject(Project project);

  TeamMemberList getAllTeamMembers(Project project);

  TaskList getAllTasks(Requirement requirement);

  RequirementList getAllRequirements(Project project);
  TaskList getAllTasks(Project project, Requirement requirement);

  ProjectList getAllProjects();

  Project getProject(String title);

  void reorderRequirements(Project project, int position, int newPosition);

  int getNumberOfTeamMembers();

  int getNumberOfTasks(Requirement requirement);

  int getNumberOfRequirements(Project project);

  int getNumberOfProjects();

  TeamMember get(Project project, int index);

  TeamMember getTeamMemberById(int ID);

  void changeStatus(Project project, String status);

  void changeRole(TeamMember teamMember, String role);

  void editProject(int projectID, String title, int customerID,
      String description, MyDate deadline, String status);
  Project getProject(int index);

  Project getProjectByID(int id);

  TeamMember getTeamMemberAtIndex(int projectID, int index);

  public TeamMemberList getTeamMembers();

  public RequirementList getAllRequirements();

  public TeamMemberList getTeamMemberList(Project project);

  public Requirement getRequirementByID(int id);

  void addHours(int projectID, int requirementID, int taskID, int teamMemberID,
      double hours);
}
