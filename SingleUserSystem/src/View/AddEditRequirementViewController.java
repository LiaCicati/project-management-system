package View;

import Mediator.ProjectManagementModel;
import Model.*;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

import java.time.LocalDate;

public class AddEditRequirementViewController
{
  @FXML private TextField requirementIdInput;
  @FXML private ChoiceBox<String> typeInput;
  @FXML private TextArea userStoryInput;
  @FXML private ComboBox<String> responsibleMemberInput;
  @FXML private TextField estimatedTimeInput;
  @FXML private TextField workedHoursInput;
  @FXML private ChoiceBox<String> statusInput;
  @FXML private DatePicker deadlineInput;
  @FXML private Label errorLabel;

  private Region root;
  private ProjectManagementModel model;
  private RequirementListViewModel requirementListViewModel;
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
    //    saveProject.setDisable(true);
    errorLabel.setText("");
  }

  public void reset()
  {
    if (viewState.getSelectedTeamMember() > -1)
    {
      Requirement requirement = model.getAllRequirements()
          .getByID(viewState.getSelectedRequirement());
      requirementIdInput.setText(requirement.getID() + "");
      typeInput.setAccessibleText(requirement.getType() + "");
      userStoryInput.setText(requirement.getUserStory());
      responsibleMemberInput
          .setAccessibleText(requirement.getResponsibleTeamMember() + "");
      estimatedTimeInput.setText(requirement.getEstimatedTime() + "");
      workedHoursInput.setText(requirement.getTimeSpent() + "");
      statusInput.setAccessibleText(requirement.getStatus());
      deadlineInput.setAccessibleText(requirement.getDeadline() + "");
    }
    else
    {
      this.errorLabel.setText("");
      this.requirementIdInput.setText("");
      this.typeInput.getSelectionModel().clearAndSelect(0);
      this.userStoryInput.setText("");
      this.responsibleMemberInput.getSelectionModel().clearAndSelect(0);
      this.estimatedTimeInput.setText("");
      this.workedHoursInput.setText("");
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

      TeamMember responsibleTeamMember = (TeamMember)responsibleMemberInput.getItems();
      double estimatedTime;
      if (estimatedTimeInput.getText().equals(""))
        throw new IllegalArgumentException("Estimated time can not be empty");
      try
      {
        estimatedTime = Integer.parseInt(estimatedTimeInput.getText());
      }
      catch (NumberFormatException e)
      {
        throw new IllegalArgumentException("Estimated time should be a number");
      }

      LocalDate today = LocalDate.now();
      if (deadlineInput.getValue().isBefore(today))
        throw new IllegalArgumentException(
            "Deadline can not be set in the past");
      int day = deadlineInput.getValue().getDayOfMonth();
      int month = deadlineInput.getValue().getMonthValue();
      int year = deadlineInput.getValue().getYear();
      MyDate deadline = new MyDate(day, month, year);



      Requirement requirement = new Requirement(requirementID, userStory, type, estimatedTime, responsibleTeamMember, deadline);
      if (viewState.getSelectedProject() > -1)
      {
        // method that should edit the requirement
      }

      else
      {
        // method that should add the requirement in the list to the selected project
        System.out.println(requirement);
      }

      System.out.println(requirement);
      errorLabel.setText("");
      reset();
      viewHandler.openView("manageProjectData");
      //      projectListViewModel.update();
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }

  @FXML private void cancelButtonPressed()
  {
    reset();
    viewHandler.openView("manageProjectData");
  }



  @FXML private void requirementCancelButtonPressed()
  {
    viewHandler.openView("manageProjectData");
  }
}

