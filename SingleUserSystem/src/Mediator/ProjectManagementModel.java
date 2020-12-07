package Mediator;

import Model.*;
import javafx.scene.Scene;

public interface ProjectManagementModel
{
  public TeamMemberList getTeamMember(String role);

  public void deleteTask(Task task);

  public void addProject(Project project);

  public void deleteTeamMember(TeamMember teamMember);

  public TaskList getAllTasks();

  public ProjectList getAllProjects();

  public void addRequirement(Requirement requirement);

  public Project getProject(String title);

  public void addTask(Task task);

  public void addTeamMember(TeamMember teamMember);

  public TeamMemberList getAllTeamMembers();

  public void deleteRequirement(Requirement requirement);

  public RequirementList getAllRequirements();

  public TeamMember addTeamMember(Name name,String role);
}
