package Mediator;

import Model.*;

public interface ProjectManagementModel
{
  TeamMember getTeamMemberByName(Name name);

  void addTeamMemberToProject(Project project, TeamMember teamMember);

  TeamMember editTeamMember(Name name, String role);

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

  ProjectList getAllProjects();

  Project getProject(String title);

  void reorderRequirements(Project project, int position, int newPosition);

  int getNumberOfTasks(Requirement requirement);

  int getNumberOfRequirements(Project project);

  int getNumberOfProjects();

  TeamMember get(Project project, int index);

  TeamMember getTeamMemberById(Project project, int ID);

  void editTask(Task task, String title, String description,
      double estimatedTime, TeamMember responsibleTeamMember, MyDate deadline);

  void editRequirement(Requirement requirement, int ID, double estimatedTime,
      TeamMember responsibleTeamMember, MyDate deadline);

  void changeStatus(Project project, String status);

  void editProject(Project project, String title, int customerID,
      String description, MyDate deadline, String status);
}
