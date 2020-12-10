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

  public RequirementListViewModel(ProjectManagementModel model,ViewState viewState)
  {
    this.model=model;
    this.list= FXCollections.observableArrayList();
    this.viewState=viewState;
    //update();
  }

  public ObservableList<RequirementViewModel> getList(){return list;}

//  public void update()
//  {
//    list.clear();
//    for(int i=0;i< model.getNumberOfRequirements();i++)
//    {
//      list.add(new RequirementViewModel(model.getRequirementByID(i));
//    }
//  }

  public void remove(Requirement requirement)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getRequirementIDProperty().get() == requirement.getID()
          && list.get(i).getDeadlineProperty().get().equals(requirement.getDeadline()) &&  list.get(i).getResponsibleteammemberProperty().get().equals(requirement.getResponsibleTeamMember()))// && list.get(i).getEstimatedtimeProperty()== requirement.getEstimatedTime())
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
