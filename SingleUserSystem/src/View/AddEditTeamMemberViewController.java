package View;

import Mediator.ProjectManagementModel;
import Model.*;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

import java.time.LocalDate;

public class AddEditTeamMemberViewController
{
  @FXML private TextField teamMemberNameInput;
  @FXML private TextField teamMemberIDInput;
  @FXML private ChoiceBox<String> rolesInput;
  @FXML private Label errorLabel;
  @FXML private Button saveTeamMember;

  private Region root;
  private ProjectManagementModel model;
  private TeamMemberListViewModel teamMemberListViewModel;
  private ViewHandler viewHandler;
  private ViewState viewState;

  public AddEditTeamMemberViewController()
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
    if(viewState.getSelectedTeamMember() > -1)
    {
      TeamMember teamMember = model.getTeamMembers().getTeamMemberById(viewState.getSelectedTeamMember());
      teamMemberNameInput.setText(teamMember.getName().toString());
      teamMemberIDInput.setText(teamMember.getId() + "");
      rolesInput.setAccessibleText(teamMember.getRole());
    }
    else {
      this.errorLabel.setText("");
      this.teamMemberNameInput.setText("");
      this.teamMemberIDInput.setText("");
      this.rolesInput.getSelectionModel().clearAndSelect(0);
    }
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void addTeamMemberSaveButton()
  {
    try
    {
      if (teamMemberNameInput.getText().equals(""))
        throw new IllegalArgumentException("Name cannot be empty");
      String firstName = teamMemberNameInput.getText();
      String lastName = teamMemberNameInput.getText();
      Name name = new Name(firstName, lastName);

      int teamMemberID;
      if (teamMemberIDInput.getText().equals(""))
        throw new IllegalArgumentException("Team member ID can not be empty");
      try
      {
        teamMemberID = Integer.parseInt(teamMemberIDInput.getText());
      }
      catch (NumberFormatException e)
      {
        throw new IllegalArgumentException("Team member ID should be a number");
      }

      TeamMember teamMember = new TeamMember(name, teamMemberID);
      String role = null;
      switch (rolesInput.getValue())
      {
        case "Team Member":
          role = TeamMember.TEAM_MEMBER;
          break;
        case "Product Owner":
          role = TeamMember.PRODUCT_OWNER;
          break;
        case "Scrum Master":
          role = TeamMember.SCRUM_MASTER;
          break;
      }
      teamMember.changeRole(role);

      if(viewState.getSelectedProject() > - 1)
      {

        /**
         * Think of a method that will add the team member in the list at the selected project on Save button click
         * We need a method in the Model Manager
         */
        //        model.changeStatus(project, status);
        //        model.editProject(project, title, customerID, description, deadline, status);
       // model.addTeamMember(viewState.getSelectedProject(), teamMember);
      }

      else {
        //        model.changeStatus(project, status);
//        model.addTeamMember(teamMember, teamMemberID, viewState.getSelectedProject());
        model.addTeamMember(viewState.getSelectedProject(), teamMember);
        System.out.println(teamMember);
      }
      System.out.println(teamMember);
      errorLabel.setText("");
      reset();
      viewHandler.openView("manageProjectData");
      teamMemberListViewModel.update();
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
}

