package Mediator;

import Model.Project;
import Model.Requirement;
import Model.Task;
import Model.TeamMember;

public interface ProjectManagementPersistence
{
  public ProjectManagementModel loadAll();

  public void saveAll(ProjectManagementModel model);

  public void save(Project project);

  public void save(TeamMember teamMember);

  public void save(Requirement requirement);

  public void save(Task task);
}
