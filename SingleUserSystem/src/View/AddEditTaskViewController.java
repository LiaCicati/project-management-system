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
import parser.XmlJsonParser;

import java.io.File;
import java.time.LocalDate;

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
    Project project = model.getAllProjects()
        .getProjectById(viewState.getSelectedProject());
    Requirement requirement = model.getAllRequirements(project)
        .getByID(viewState.getSelectedRequirement());
    Task task = model.getAllTasks(
        model.getAllProjects().getProjectById(viewState.getSelectedProject()),
        requirement).getTaskByID(viewState.getSelectedTask());
    if (viewState.getSelectedTask() > -1)
    {
      requirementIDInput.setText(task.getRequirementID() + "");
      taskIDInput.setEditable(false);
      taskIDInput.setText(task.getID() + "");
      taskTitleInput.setText(task.getTitle());
      taskDescriptionInput.setText(task.getDescription());
      taskResponsibleMemberInput
          .setAccessibleText(task.getResponsibleTeamMember() + "");
      taskEstimatedTimeInput.setText(task.getEstimatedTime() + "");
      taskStatusInput.setAccessibleText(task.getStatus());
      taskDeadlineInput.getEditor().setText(requirement.getDeadline() + "");
    }
    else
    {
      this.taskErrorLabel.setText("");
      this.taskIDInput.setEditable(true);
      this.taskIDInput.setText("");
      this.requirementIDInput.setText(requirement.getID() + "");
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
    try
    {
      if (taskTitleInput.getText().equals(""))
        throw new IllegalArgumentException("Title cannot be empty");
      String taskTitle = taskTitleInput.getText();

      int taskID;
      if (taskIDInput.getText().equals(""))
        throw new IllegalArgumentException("Task ID can not be empty");
      try
      {
        taskID = Integer.parseInt(taskIDInput.getText());
      }
      catch (NumberFormatException e)
      {
        throw new IllegalArgumentException("Task ID should be a number");
      }

      if (taskDescriptionInput.getText().equals(""))
        throw new IllegalArgumentException("Description cannot be empty");
      String taskDescription = taskDescriptionInput.getText();

      TeamMember responsibleTeamMember = new TeamMember(
          new Name("Bob", "Turquoise"), 2);
      double estimatedTime;
      if (taskEstimatedTimeInput.getText().equals(""))
        throw new IllegalArgumentException("Estimated time can not be empty");
      try
      {
        estimatedTime = Double.parseDouble(taskEstimatedTimeInput.getText());
      }
      catch (NumberFormatException e)
      {
        throw new IllegalArgumentException(
            "Estimated time should be a number, indicating the hours, ex : 25.5");
      }
      if (taskDeadlineInput.getValue() == null)
      {
        taskErrorLabel.setText("A deadline should be added to the task");
        throw new IllegalStateException(taskErrorLabel.getText());
      }

      LocalDate today = LocalDate.now();
      if (taskDeadlineInput.getValue().isBefore(today))
        throw new IllegalArgumentException(
            "Deadline can not be set in the past");
      int day = taskDeadlineInput.getValue().getDayOfMonth();
      int month = taskDeadlineInput.getValue().getMonthValue();
      int year = taskDeadlineInput.getValue().getYear();
      MyDate deadline = new MyDate(day, month, year);

      String status = null;
      switch (taskStatusInput.getValue())
      {
        case "Started":
          status = Requirement.STARTED;
          break;
        case "Ended":
          status = Requirement.ENDED;
          break;
        case "Not Started":
          status = Requirement.NOT_STARTED;
          break;
      }
      Requirement requirementID = model.getAllProjects()
          .getProjectById(viewState.getSelectedProject()).getAllRequirements()
          .getByID(viewState.getSelectedRequirement());
      Task task = new Task(requirementID, taskID, taskTitle, taskDescription,
          estimatedTime, responsibleTeamMember, deadline);

      if (viewState.getSelectedTask() > -1) // edit
      {
        model.editTask(task, taskID, viewState.getSelectedProject(),
            viewState.getSelectedRequirement(), status);

        model.getProjectByID(viewState.getSelectedProject()).saveToDisk();
      }
      else // add
      {
        model.addTask(viewState.getSelectedRequirement(),
            viewState.getSelectedProject(), task);

        model.getProjectByID(viewState.getSelectedProject()).saveToDisk();
      }

      taskErrorLabel.setText("");
      reset();
      viewHandler.openView("manageRequirementData");
      taskListViewModel.update();
    }
    catch (Exception e)
    {
      taskErrorLabel.setText(e.getMessage());
    }
  }

  @FXML private void cancelTaskButtonPressed()
  {
    viewHandler.openView("manageRequirementData");
  }
}
