package View;

import Mediator.ProjectManagementModel;
import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import Model.Task;
import Model.TeamMember;
import javafx.scene.control.*;

import javafx.scene.control.Label;
import javafx.scene.layout.Region;

import java.awt.*;
import java.util.Optional;

public class ManageRequirementDataViewController
{
  @FXML private Label errorLabel;
  @FXML private TableView<TaskViewModel> taskListTable;
  @FXML private TableColumn<TaskViewModel, Number> requirementIDColumn;
  @FXML private TableColumn<TaskViewModel, Number> taskIDColumn;
  @FXML private TableColumn<TaskViewModel, String> taskTitleColumn;
  @FXML private TableColumn<TaskViewModel, String> taskDescriptionColumn;
  @FXML private TableColumn<TaskViewModel, Number> taskEstimatedTimeColumn;
  @FXML private TableColumn<TaskViewModel, String> taskResponsibleMemberColumn;
  @FXML private TableColumn<TaskViewModel, String> taskDeadlineColumn;
  @FXML private TableColumn<TaskViewModel, String> taskStatusColumn;

  @FXML private TableView<TeamMemberViewModel> teamListTable;
  @FXML private TableColumn<TeamMemberViewModel, String> teamNameColumn;
  @FXML private TableColumn<TeamMemberViewModel, Number> teamIDColumn;
  @FXML private TableColumn<TeamMemberViewModel, String> teamRoleColumn;

  private Region root;
  private ProjectManagementModel model;
  private ViewHandler viewHandler;
  private ViewState viewState;
  private TaskListViewModel taskListViewModel;
  private TeamMemberListViewModel teamMemberListViewModel;

  public ManageRequirementDataViewController()
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

        requirementIDColumn.setCellValueFactory(
            cellData -> cellData.getValue().getRequirementIDProperty());
    taskIDColumn.setCellValueFactory(
        cellData -> cellData.getValue().getTaskIDProperty());
    taskTitleColumn.setCellValueFactory(
        cellData -> cellData.getValue().getTaskTitleProperty());
    taskDescriptionColumn.setCellValueFactory(
        cellData -> cellData.getValue().getTaskDescriptionProperty());
    taskEstimatedTimeColumn.setCellValueFactory(
        cellData -> cellData.getValue().getTaskEstimatedTimeProperty());
    taskResponsibleMemberColumn.setCellValueFactory(
        cellData -> cellData.getValue().getTaskResponsibleMemberProperty());
    taskDeadlineColumn.setCellValueFactory(
        cellData -> cellData.getValue().getTaskDeadlineProperty());
    taskStatusColumn.setCellValueFactory(
        cellData -> cellData.getValue().getTaskStatusProperty());
    taskListTable.setItems(taskListViewModel.getList());

    teamNameColumn
        .setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    teamIDColumn
        .setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
    teamRoleColumn
        .setCellValueFactory(cellData -> cellData.getValue().getRoleProperty());

        teamListTable.setItems(teamMemberListViewModel.getList());
  }

  public void reset()
  {
    errorLabel.setText("");
    taskListViewModel.update();
        teamMemberListViewModel.update();
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void addTaskButtonPressed()
  {
    viewState.setSelectedTask(-1);
    viewHandler.openView("addEditTask");
  }

  private boolean confirmation()
  {
    int index = taskListTable.getSelectionModel().getSelectedIndex();
    TaskViewModel selectedItem = taskListTable.getItems().get(index);
    if (index >= taskListTable.getItems().size())
    {
      return false;
    }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(
        "Are you sure you wish to remove the following task: "
            + selectedItem.getTaskIDProperty().get() + "?");
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent() && (result.get() == ButtonType.OK));
  }


  @FXML private void removeTaskButtonPressed()
  {
    errorLabel.setText("");
    try
    {
      TaskViewModel selectedItem = taskListTable.getSelectionModel()
          .getSelectedItem();
      boolean remove = confirmation();
      if (remove)
      {
        Project project = model.getAllProjects().getProjectById(viewState.getSelectedProject());
        Requirement requirement = model.getAllRequirements(project).getByID(viewState.getSelectedRequirement());
        Task task = model.getAllTasks(project, requirement).getTaskByID(selectedItem.getTaskIDProperty().get());
        model.removeTaskFromRequirement(requirement, task);
        taskListViewModel.remove(task);
        taskListTable.getSelectionModel().clearSelection();
      }
    }
    catch (Exception e)
    {
      errorLabel
          .setText("Choose a task you wish to remove from the list");
    }
  }

  @FXML private void editTaskButtonPressed()
  {
    try
    {
      TaskViewModel selectedItem = taskListTable.getSelectionModel()
          .getSelectedItem();
      viewState.setSelectedTask(selectedItem.getTaskIDProperty().getValue());
      viewHandler.openView("addEditTask");

    }
    catch (Exception e)
    {
      errorLabel.setText("Select a task from the list");
    }
  }

  @FXML private void manageDataTaskButtonPressed()
  {
  }

  @FXML private void backButtonPressed()
  {
    viewState.setSelectedRequirement(-1);
    viewHandler.openView("manageProjectData");
  }
}
