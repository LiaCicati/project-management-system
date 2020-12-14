package View;

import Mediator.ProjectManagementModel;
import Model.*;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;

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
  private TaskListViewModel taskListViewModel;
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
    this.taskListViewModel = new TaskListViewModel(model, viewState);
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

  @FXML private void backButtonPressed()
  {
    viewState.setSelectedTask(-1);
    viewHandler.openView("manageRequirementData");
  }
}
