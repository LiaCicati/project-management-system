package View;

public class ViewState
{
  private int selectedProject;
  private int selectedRequirement;
  private int selectedTask;
  private int selectedTeamMember;

  public ViewState()
  {
    selectedProject = -1;
    selectedRequirement = -1;
    selectedTask = -1;
    selectedTeamMember = -1;

  }

  public int getSelectedProject()
  {
    return selectedProject;
  }

  public int getSelectedRequirement()
  {
    return selectedRequirement;
  }

  public int getSelectedTask()
  {
    return selectedTask;
  }

  public int getSelectedTeamMember()
  {
    return selectedTeamMember;
  }

  public void setSelectedProject(int id)
  {
    this.selectedProject = id;
  }

  public void setSelectedRequirement(int id)
  {
    this.selectedRequirement = id;
  }

  public void setSelectedTask(int id)
  {
    this.selectedTask = id;
  }

  public void setSelectedTeamMember(int id)
  {
    this.selectedTeamMember = id;
  }

}

