package View;

import Mediator.ProjectManagementModel;
import Model.Project;
import Model.ProjectList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProjectListViewModel
{
  private ObservableList<ProjectViewModel> list;
  private ProjectManagementModel model;
  private ViewState viewState;

  public ProjectListViewModel(ProjectManagementModel model, ViewState viewState)
  {
    this.model = model;
    this.list = FXCollections.observableArrayList();
    this.viewState = viewState;
//    update();
  }

    public void update()
    {
      list.clear();
      for (int i = 0; i < model.getNumberOfProjects(); i++)
      {
        list.add(new ProjectViewModel(model.getProject(i)));
      }
    }


  public ObservableList<ProjectViewModel> getList()
  {
    return list;
  }

  public void remove(Project project)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getTitleProperty().get().equals(project.getTitle())
          && list.get(i).getCustomerIDProperty().get() == project
          .getCustomerID() && list.get(i).getDescriptionProperty().get()
          .equals(project.getDescription()) && list.get(i).getDeadlineProperty()
          .get().equals(project.getDeadline().toString()))
      {
        list.remove(i);
        break;
      }
    }
  }

  public void add(Project project)
  {
    list.add(new ProjectViewModel(project));
  }
}
