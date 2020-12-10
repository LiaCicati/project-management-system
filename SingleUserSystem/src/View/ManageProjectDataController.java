package View;

import Mediator.ProjectManagementModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class ManageProjectDataController
{

  @FXML private Label errorLabelTeamMember;
  @FXML private Label errorLabelRequirement;
  private Region root;
  private ProjectManagementModel model;
  private ViewHandler viewHandler;
  private ViewState viewState;

  public ManageProjectDataController()
  {
    // Called by FXMLLoader
  }

  public void init(ViewHandler viewHandler, ProjectManagementModel model,
      Region root, ViewState viewState)
  {
    this.model = model;
    this.viewHandler = viewHandler;
    this.viewState = viewState;
    this.root = root;
    //    reset();
        errorLabelTeamMember.setText("");
        errorLabelRequirement.setText("");
  }

  public void reset()
  {

  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void backButtonPressed()
  {
    viewState.setSelectedProject(-1);
    viewHandler.openView("projectList");
  }

  @FXML private void removeRequirementButtonPressed()
  {
  }

  @FXML private void editRequirementButtonPressed()
  {
  }

  @FXML private void manageRequirementDataButtonPressed()
  {
  }

  @FXML private void addRequirementButtonPressed()
  {
  }

  @FXML private void addTeamMemberButtonPressed() {
    //    viewState.setSelectedTeamMember(-1);
    viewHandler.openView("addEditTeamMember");

  }

  @FXML private void removeTeamMemberButtonPressed() {

  }

  @FXML private void editTeamMemberButtonPressed() {

  }
}

//Here is old code

//package View;
//
//import Mediator.ProjectManagementModel;
//import Model.Name;
//import Model.Project;
//import Model.TeamMember;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//import javafx.scene.layout.Region;
//
//import java.util.Optional;
//
//public class ManageProjectDataController
//{
//  @FXML private TableView<TeamMemberViewModel> teamListTable;
//  @FXML private TableColumn<TeamMemberViewModel, String> teamNameColumn;
//  @FXML private TableColumn<TeamMemberViewModel, Number> teamIDColumn;
//  @FXML private TableColumn<TeamMemberViewModel, String> teamRoleColumn;
//  @FXML private Label errorLabel;
//
//
//  private Region root;
//  private ProjectManagementModel model;
//  private ViewHandler viewHandler;
//  private ViewState viewState;
//  private TeamMemberListViewModel teamMemberListViewModel;
//
//  public ManageProjectDataController()
//  {
//    // Called by FXMLLoader
//  }
//
//  public void init(ViewHandler viewHandler, ProjectManagementModel model,
//      Region root, ViewState viewState)
//  {
//    this.model = model;
//    this.viewHandler = viewHandler;
//    this.viewState = viewState;
//    this.root = root;
//    this.teamMemberListViewModel = new TeamMemberListViewModel(model,viewState);
//
//    teamNameColumn.setCellValueFactory(
//        cellData -> cellData.getValue().getNameProperty());
//    teamIDColumn.setCellValueFactory(
//        cellData -> cellData.getValue().getIdProperty());
//    teamRoleColumn.setCellValueFactory(
//        cellData -> cellData.getValue().getRoleProperty());
//
//    teamListTable.setItems(teamMemberListViewModel.getList());
//    errorLabel.setText("");
//  }
//
//  public void reset()
//  {
//    errorLabel.setText("");
//
//    teamMemberListViewModel.update();
//  }
//
//  public Region getRoot()
//  {
//    return root;
//  }
//
//  @FXML private void backButtonPressed()
//  {
//    viewState.setSelectedProject(-1);
//    viewHandler.openView("projectList");
//  }
//
//  @FXML private void removeTeamMemberButtonPressed()
//  {
//    errorLabel.setText("");
//    try
//    {
//      TeamMemberViewModel selectedItem = teamListTable.getSelectionModel()
//          .getSelectedItem();
//      boolean remove = confirmation();
//      if (remove)
//      {
//        Name name = new Name(selectedItem.getNameProperty().get(),"");
//        TeamMember teamMember = model.getAllTeamMembers().getTeamMemberByName(name);
//        model.removeTeamMember(teamMember);
//        teamMemberListViewModel.remove(teamMember);
//        teamListTable.getSelectionModel().clearSelection();
//      }
//    }
//    catch (Exception e)
//    {
//      errorLabel.setText("Choose a team member you want to remove from the list");
//    }
//  }
////
////   if (remove)
////  {
////    Project project = model.getAllProjects()
////        .getProjectByTitle(selectedItem.getTitleProperty().get());
////    model.removeProject(project);
////    projectListViewModel.remove(project);
////    projectListTable.getSelectionModel().clearSelection();
////  }
//
//
//  @FXML private void editTeamMemberButtonPressed()
//  {
//    try
//    {
//      TeamMemberViewModel selectedItem = teamListTable.getSelectionModel()
//          .getSelectedItem();
//      viewState
//          .setSelectedProject(selectedItem.getIdProperty().get());
//      viewHandler.openView("addEditTeamMember");
//    }
//    catch (Exception e)
//    {
//      errorLabel.setText("Select a team member from the list");
//    }
//  }
//
//  @FXML private void addTeamMemberButtonPressed()
//  {
//    viewHandler.openView("addEditTeamMember");
//  }
//
//  private boolean confirmation()
//  {
//    int index = teamListTable.getSelectionModel().getSelectedIndex();
//    TeamMemberViewModel selectedItem = teamListTable.getItems().get(index);
//    if (index >= teamListTable.getItems().size())
//    {
//      return false;
//    }
//    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//    alert.setTitle("Confirmation");
//    alert.setHeaderText(
//        "Are you sure you want to remove the following team member: " + selectedItem
//            .getNameProperty().get() + "?");
//    Optional<ButtonType> result = alert.showAndWait();
//    return (result.isPresent() && (result.get() == ButtonType.OK));
//  }
//}

