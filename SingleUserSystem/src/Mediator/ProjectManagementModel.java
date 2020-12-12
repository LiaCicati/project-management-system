package Mediator;

import Model.*;

public interface ProjectManagementModel
{
  TeamMember getTeamMemberByName(Name name);

  void addTeamMember(int projectID, TeamMember teamMember);

  void editTeamMember(int projectID, int ID, Name name, int teamMemberID, String role);

  void removeTeamMember(TeamMember teamMember);

  void addTaskToRequirement(Requirement requirement, Task task);

  void removeTaskFromRequirement(Requirement requirement, Task task);

  void addRequirementToProject(Project project, Requirement requirement);

  void removeRequirementFromProject(Project project, int requirementID);

  void addProject(Project project);

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

  void editTask(Task task, String title, String description,
      double estimatedTime, TeamMember responsibleTeamMember, MyDate deadline);

  void editRequirement(Requirement requirement, int ID, double estimatedTime,
      TeamMember responsibleTeamMember, MyDate deadline);

  void changeStatus(Project project, String status);

  void changeRole(TeamMember teamMember,String role);

  void editProject(int projectID, String title, int customerID,
      String description, MyDate deadline, String status);

  public Project getProject(int index);

  Project getProjectByID(int id);

  TeamMember getTeamMemberAtIndex(int projectID, int index);

  //  Requirement getRequirement(int index);
  //
  //  Requirement getRequirementByID(int index);

  public TeamMemberList getTeamMembers();
  public RequirementList getAllRequirements();

  public TeamMemberList getTeamMemberList(Project project);
}
