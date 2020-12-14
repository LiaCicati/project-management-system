package View;
import Mediator.ProjectManagementModel;
import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class RegisterHoursController
{
  @FXML private ComboBox<String> teamMembers;
  @FXML TextField hoursWorked;
  @FXML Label errorLabel;

  private Region root;
  private ProjectManagementModel model;
  private TeamMemberListViewModel teamMemberListViewModel;
  private ViewHandler viewHandler;
  private ViewState viewState;

  public RegisterHoursController()
  {
    // Called by FXMLLoader
  }

  public void init(ViewHandler viewHandler,ProjectManagementModel model, Region root, ViewState viewState)
  {
    this.model = model;
    this.viewHandler = viewHandler;
    this.viewState = viewState;
    this.root = root;
   reset();
  }

  public void reset()
  {
//    errorLabel.setText("");
//    teamMemberListViewModel.update();

  }
  public Region getRoot()
  {
    return root;
  }

  @FXML private void saveDataButtonPressed()
  {
  }

  @FXML private void cancelDataButtonPressed()
  {
    viewHandler.openView("manageTaskData");
  }
}
