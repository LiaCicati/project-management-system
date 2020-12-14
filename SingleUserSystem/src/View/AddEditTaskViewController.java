package View;

import Mediator.ProjectManagementModel;
import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class AddEditTaskViewController
{
  @FXML private TextField requirementIDInput;
  @FXML private TextField taskIDInput;
  @FXML private TextField taskTitleInput;
  @FXML private TextArea taskDescriptionInput;
  @FXML private ComboBox<String> taskResponsibleMemberInput;
  @FXML private TextField taskEstimatedTimeInput;
  @FXML private ChoiceBox<String> taskStatusInput;
  @FXML private DatePicker taskDeadlineInput;
  @FXML private Label taskErrorLabel;

  private Region root;
  private ProjectManagementModel model;
  private TaskListViewModel taskListViewModel;
  private ViewHandler viewHandler;
  private ViewState viewState;

  public AddEditTaskViewController()
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
    reset();
    taskErrorLabel.setText("");
  }

  public void reset()
  {
    if (viewState.getSelectedTask() > -1)
    {
      //      Task task = model.getAllTasks(
      //          model.getAllProjects().getProjectById(viewState.getSelectedProject())
      //              .getAllRequirements().getByID(viewState.getSelectedRequirement()))
      //          .getTaskByID(viewState.getSelectedTask());
      Project project = model.getAllProjects()
          .getProjectById(viewState.getSelectedProject());
      Requirement requirement = model.getAllRequirements(project)
          .getByID(viewState.getSelectedRequirement());
      Task task = model.getAllTasks(
          model.getAllProjects().getProjectById(viewState.getSelectedProject()),
          requirement).getTaskByID(viewState.getSelectedTask());
      requirementIDInput.setText(task.getRequirementID() + "");
      taskIDInput.setText(task.getID() + "");
      taskTitleInput.setText(task.getTitle());
      taskDescriptionInput.setText(task.getDescription());
      taskResponsibleMemberInput
          .setAccessibleText(task.getResponsibleTeamMember() + "");
      taskEstimatedTimeInput.setText(task.getEstimatedTime() + "");
      taskStatusInput.setAccessibleText(task.getStatus());
      taskDeadlineInput.setAccessibleText(task.getDeadline() + "");
    }
    else
    {
      this.taskErrorLabel.setText("");
      //      this.requirementIDInput.setText("");
      this.taskIDInput.setText("");
      this.taskTitleInput.setText("");
      this.taskDescriptionInput.setText("");
      this.taskResponsibleMemberInput.getEditor().setText("");
      this.taskEstimatedTimeInput.setText("");
      this.taskStatusInput.getSelectionModel().clearAndSelect(0);
      this.taskDeadlineInput.getEditor().setText("");
    }
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void saveTaskButtonPressed()
  {
    
  }

  @FXML private void cancelTaskButtonPressed()
  {
    viewHandler.openView("manageRequirementData");
  }
}
