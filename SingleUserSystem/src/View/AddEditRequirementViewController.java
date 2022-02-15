package View;

import Mediator.ProjectManagementModel;
import Model.*;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import parser.XmlJsonParser;

import java.io.File;
import java.time.LocalDate;

public class AddEditRequirementViewController
{
  @FXML private TextField requirementIdInput;
  @FXML private ChoiceBox<String> typeInput;
  @FXML private TextArea userStoryInput;
  @FXML private ComboBox<TeamMemberViewModel> responsibleMemberInput;
  @FXML private TextField estimatedTimeInput;
  @FXML private TextField workedHoursInput;
  @FXML private ChoiceBox<String> statusInput;
  @FXML private DatePicker deadlineInput;
  @FXML private Label errorLabel;

  private Region root;
  private ProjectManagementModel model;
  private RequirementListViewModel requirementListViewModel;
  private TeamMemberListViewModel teamMemberListViewModel;
  private ViewHandler viewHandler;
  private ViewState viewState;

  public AddEditRequirementViewController()
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
    errorLabel.setText("");
  }

  public void reset()
  {
    if (viewState.getSelectedRequirement() > -1)
    {
      Requirement requirement = model.getAllRequirements(
          model.getAllProjects().getProjectById(viewState.getSelectedProject()))
          .getByID(viewState.getSelectedRequirement());
//      Requirement requirement1 = model.getAllRequirements(model.getAllProjects().getProjectById(viewState.getSelectedProject())).
      requirementIdInput.setText(requirement.getID() + "");
      requirementIdInput.setEditable(false);
      typeInput.setAccessibleText(requirement.getType() + "");
      userStoryInput.setText(requirement.getUserStory());
      responsibleMemberInput
          .setAccessibleText(requirement.getResponsibleTeamMember() + "");
      estimatedTimeInput.setText(requirement.getEstimatedTime() + "");
      statusInput.setAccessibleText(requirement.getStatus());
      deadlineInput.getEditor().setText(requirement.getDeadline() + "");
    }
    else
    {
      this.errorLabel.setText("");
      this.requirementIdInput.setText("");
      this.requirementIdInput.setEditable(true);
      this.typeInput.getSelectionModel().clearAndSelect(0);
      this.userStoryInput.setText("");
      this.responsibleMemberInput.getSelectionModel().clearAndSelect(0);
      this.estimatedTimeInput.setText("");
      this.statusInput.getSelectionModel().clearAndSelect(0);
      this.deadlineInput.getEditor().setText("");
    }
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void requirementSaveButtonPressed()
  {
    try
    {
      if (userStoryInput.getText().equals(""))
        throw new IllegalArgumentException("User story cannot be empty");
      String userStory = userStoryInput.getText();

      int requirementID;
      if (requirementIdInput.getText().equals(""))
        throw new IllegalArgumentException("Requirement ID can not be empty");
      try
      {
        requirementID = Integer.parseInt(requirementIdInput.getText());
      }
      catch (NumberFormatException e)
      {
        throw new IllegalArgumentException("Requirement ID should be a number");
      }

      Type type = null;
      switch (typeInput.getValue())
      {
        case "Functional":
          type = Type.FUNCTIONAL;
          break;
        case "Non-functional":
          type = Type.NON_FUNCTIONAL;
          break;
        case "Project Related":
          type = Type.PROJECT_RELATED;
          break;
      }

      TeamMember responsibleTeamMember = new TeamMember(
          new Name("Bob", "Turquoise"), 2);
      //      responsibleMemberInput.setItems(teamMemberListViewModel.getList());
      double estimatedTime;
      if (estimatedTimeInput.getText().equals(""))
        throw new IllegalArgumentException("Estimated time can not be empty");
      try
      {
        estimatedTime = Double.parseDouble(estimatedTimeInput.getText());
      }
      catch (NumberFormatException e)
      {
        throw new IllegalArgumentException(
            "Estimated time should be a number, indicating the hours");
      }
      if (deadlineInput.getValue() == null)
      {
        errorLabel.setText("A deadline should be added to the requirement");
        throw new IllegalStateException(errorLabel.getText());
      }

      LocalDate today = LocalDate.now();
      if (deadlineInput.getValue().isBefore(today))
        throw new IllegalArgumentException(
            "Deadline can not be set in the past");
      int day = deadlineInput.getValue().getDayOfMonth();
      int month = deadlineInput.getValue().getMonthValue();
      int year = deadlineInput.getValue().getYear();
      MyDate deadline = new MyDate(day, month, year);
      String status = null;
      switch (statusInput.getValue())
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
        case "Approved":
          status = Requirement.APPROVED;
          break;
        case "Rejected":
          status = Requirement.REJECTED;
          break;
      }

      Requirement requirement = new Requirement(requirementID, userStory, type,
          estimatedTime, responsibleTeamMember, deadline);

      if (viewState.getSelectedRequirement() > -1)
      {
        model.editRequirement(viewState.getSelectedProject(),
            viewState.getSelectedRequirement(),
            new Requirement(requirementID, userStory, type, estimatedTime,
                responsibleTeamMember, deadline), status);

        model.getProjectByID(viewState.getSelectedProject()).saveToDisk();
      }
      else
      {
        model.addRequirement(viewState.getSelectedProject(), requirement);

        model.getProjectByID(viewState.getSelectedProject()).saveToDisk();
      }

      errorLabel.setText("");
      reset();
      viewHandler.openView("manageProjectData");
      requirementListViewModel.update();
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }

  @FXML private void requirementCancelButtonPressed()
  {
    viewHandler.openView("manageProjectData");
  }
}

