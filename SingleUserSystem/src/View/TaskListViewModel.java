package View;

import Model.*;
import Mediator.ProjectManagementModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TaskListViewModel
{
  private ObservableList<TaskViewModel> list;
  private ProjectManagementModel model;
  private ViewState viewState;

  public TaskListViewModel(ProjectManagementModel model, ViewState viewState)
  {
    this.model = model;
    this.list = FXCollections.observableArrayList();
    this.viewState = viewState;
    update();
  }

  public ObservableList<TaskViewModel> getList()
  {
    return list;
  }

  public void update()
  {
    list.clear();
    Project project = model.getAllProjects()
        .getProjectById(viewState.getSelectedProject());
    Requirement requirement = model.getAllRequirements(project)
        .getByID(viewState.getSelectedRequirement());
    for (Task task : model.getAllTasks(project, requirement).getAllTasks())
    {
      list.add(new TaskViewModel(task));
    }
  }

  public void remove(Task task)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getRequirementIDProperty().getValue() == (task
          .getRequirementID()) && list.get(i).getTaskIDProperty().getValue()
          .equals(task.getID()) && list.get(i).getTaskTitleProperty().getValue()
          .equals(task.getTitle()) && list.get(i).getTaskStatusProperty()
          .getValue().equals(task.getStatus()) && list.get(i)
          .getTaskDeadlineProperty().getValue()
          .equals(task.getDeadline().toString()))
      {
        list.remove(i);
        break;
      }
    }

  }

  public void add(Task task)
  {
    list.add(new TaskViewModel(task));
  }
}
