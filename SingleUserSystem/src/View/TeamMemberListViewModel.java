//package View;
//
//import Mediator.ProjectManagementModel;
//import Mediator.TeamMemberListModel;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import Model.*;
//
//public class TeamMemberListViewModel
//{
//  private ObservableList<TeamMemberViewModel> list;
//  private TeamMemberListModel model;
//
//  public TeamMemberListViewModel(TeamMemberListModel model)
//  {
//    this.model=model;
//    this.list= FXCollections.observableArrayList();
//    update();
//  }
//
//  public ObservableList<TeamMemberViewModel> getList(){return list;}
//
//  public void update()
//  {
//    list.clear();
//    for(int i=0;i< model.teamMemberListSize();i++)
//    {
//      list.add(new TeamMemberViewModel(model.getTeamMember(i)));
//    }
//  }
//
//  public void remove(TeamMember teamMember)
//  {
//    for (int i = 0; i < list.size(); i++)
//    {
//      if (list.get(i).getNameProperty().get().equals(teamMember.getName())
//          && list.get(i).getIdProperty().get() == teamMember.getId())
//      {
//        list.remove(i);
//        break;
//      }
//    }
//  }
//
//  public void add(TeamMember teamMember)
//  {
//    list.add(new TeamMemberViewModel(teamMember));
//  }
//}
