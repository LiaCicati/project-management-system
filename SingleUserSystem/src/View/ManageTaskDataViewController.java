package View;

import Mediator.ProjectManagementModel;
import Model.*;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

import java.util.Optional;

public class ManageTaskDataViewController
{
  @FXML private Label errorLabel;
  @FXML private TableView<TeamMemberViewModel> teamTable;
  @FXML private TableColumn<TeamMemberViewModel, String> teamMemberNameColumn;
  @FXML private TableColumn<TeamMemberViewModel, Number> hoursWorkedColumn;

  private Region root;
  private ProjectManagementModel model;
  private ViewState viewState;
  private ViewHandler viewHandler;
  private TeamMemberListViewModel teamMemberListViewModel;

  public ManageTaskDataViewController()
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
    this.teamMemberListViewModel = new TeamMemberListViewModel(model,
        viewState);
    reset();
    teamMemberNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    hoursWorkedColumn.setCellValueFactory(
        cellData -> cellData.getValue().getHoursWorkedProperty());
    teamTable.setItems(teamMemberListViewModel.getList());
  }

  public void reset()
  {
    errorLabel.setText("");
    teamMemberListViewModel.update();
  }

  public Region getRoot()
  {
    return root;
  }

  private boolean confirmation()
  {
    int index = teamTable.getSelectionModel().getSelectedIndex();
    TeamMemberViewModel selectedItem = teamTable.getItems().get(index);
    if (index >= teamTable.getItems().size())
    {
      return false;
    }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(
        "Are you sure you wish to remove the following team member: "
            + selectedItem.getNameProperty().get() + "?");
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent() && (result.get() == ButtonType.OK));
  }

  @FXML private void removeTeamMemberButtonPressed()
  {
    errorLabel.setText("");
    try
    {
      TeamMemberViewModel selectedItem = teamTable.getSelectionModel()
          .getSelectedItem();
      boolean remove = confirmation();
      if (remove)
      {
        Project project = model.getAllProjects()
            .getProjectById(viewState.getSelectedProject());
        Requirement requirement = model.getAllRequirements(project)
            .getByID(viewState.getSelectedRequirement());
        Task task = model.getAllTasks(project, requirement)
            .getTaskByID(viewState.getSelectedTask());
        TeamMember teamMember = model
            .getAllTeamMembers(viewState.getSelectedProject(),
                viewState.getSelectedRequirement(), viewState.getSelectedTask(),
                selectedItem.getIdProperty().get());
        model.removeTeamMemberFromTask(task, teamMember);
        teamMemberListViewModel.remove(teamMember);
        teamTable.getSelectionModel().clearSelection();
      }
    }
    catch (Exception e)
    {
      errorLabel
          .setText("Choose a team member you wish to remove from the list");
    }
  }

  @FXML private void backButtonPressed()
  {
    viewState.setSelectedTask(-1);
    viewHandler.openView("manageRequirementData");
  }
}
