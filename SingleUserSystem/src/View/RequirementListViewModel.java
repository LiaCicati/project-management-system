package View;

import Mediator.ProjectManagementModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.*;

public class RequirementListViewModel
{
  private ObservableList<RequirementViewModel> list;
  private ProjectManagementModel model;
  private ViewState viewState;

  public RequirementListViewModel(ProjectManagementModel model,
      ViewState viewState)
  {
    this.model = model;
    this.list = FXCollections.observableArrayList();
    this.viewState = viewState;
    update();
  }

  public ObservableList<RequirementViewModel> getList()
  {
    return list;
  }

  public void update()
  {
    list.clear();
    for (int i = 0; i < model.getAllRequirements(
        model.getAllProjects().getProjectById(viewState.getSelectedProject()))
        .getSize(); i++)
    {
      list.add(new RequirementViewModel(model.getAllRequirements(
          model.getAllProjects().getProjectById(viewState.getSelectedProject()))
          .getRequirement(i)));
    }
  }

  public void remove(Requirement requirement)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getRequirementIDProperty().getValue() == (requirement
          .getID()) && list.get(i).getUserStoryProperty().getValue()
          .equals(requirement.getUserStory()) && list.get(i).getStatusProperty()
          .getValue().equals(requirement.getStatus()) && list.get(i)
          .getDeadlineProperty().getValue()
          .equals(requirement.getDeadline().toString()))
      {
        list.remove(i);
        break;
      }
    }
  }

  public void add(Requirement requirement)
  {
    list.add(new RequirementViewModel(requirement));
  }
}
