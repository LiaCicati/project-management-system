package View;

import Mediator.ProjectManagementModel;
import Model.Name;
import Model.Project;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import Model.TeamMember;

public class AddTeamMemberViewController
{
  @FXML private  TextField teammemberNameInput;
  @FXML private  TextField teammemberIDInput;
  @FXML private ChoiceBox rolesInput;
  @FXML private Label errorLabel;
  private Region root;
  private ViewHandler viewHandler;
  private ProjectManagementModel model;

  public AddTeamMemberViewController(){}

  public void init(ViewHandler viewHandler, ProjectManagementModel model,Region root)
  {
    this.viewHandler=viewHandler;
    this.model=model;
    this.root=root;
    reset();
  }

  public void reset()
  {
    this.errorLabel.setText("");
    this.teammemberNameInput.setText("");
    this.teammemberIDInput.setText("");
    this.rolesInput.getSelectionModel().clearAndSelect(0);
  }

  public Region getRoot(){return root;}

  @FXML private void addTeamMemberSaveButton()
  {
    try
    {
      if (teammemberNameInput.getText().equals(""))
        throw new IllegalArgumentException("Name cannot be empty");
      Name name = new Name(teammemberNameInput.getText(),"");


      int teammemberID;
      if (teammemberIDInput.getText().equals(""))
        throw new IllegalArgumentException("Customer ID can not be empty");
      try
      {
        teammemberID = Integer.parseInt(teammemberIDInput.getText());
      }
      catch (NumberFormatException e)
      {
        throw new IllegalArgumentException("ID should be a number");
      }

      TeamMember teamMember = new TeamMember(name,teammemberID); //type problem
      String role = null;
      Object value = rolesInput.getValue();
      if ("Team Member".equals(value))
      {
        role = TeamMember.TEAM_MEMBER;
      }
      else if ("Scrum Master".equals(value))
      {
        role = TeamMember.SCRUM_MASTER;
      }
      else if ("Product Owner".equals(value))
      {
        role = TeamMember.PRODUCT_OWNER;
      }
      model.changeRole(teamMember, role);
      model.addTeamMember(teamMember);
      viewHandler.closeView();
      viewHandler.openView("TeamMemberView");
    }
    catch (Exception e)
    {
      errorLabel.setText(e.getMessage());
    }
  }

  @FXML private void cancelButtonPressed()
  {
    reset();
    viewHandler.openView("TeamMemberListView");
  }
}
