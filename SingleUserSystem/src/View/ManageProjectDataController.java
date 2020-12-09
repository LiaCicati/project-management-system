package View;

import Mediator.ProjectManagementModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;

public class ManageProjectDataController
{

  private Region root;
  private ProjectManagementModel model;
  private ViewHandler viewHandler;
  private ViewState viewState;

  public ManageProjectDataController()
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
    //    reset();
    //    errorLabel.setText("");
  }

  public void reset()
  {

  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void backButtonPressed()
  {
    viewHandler.openView("projectList");
  }

  @FXML private void removeRequirementButtonPressed()
  {
  }

  @FXML private void editRequirementButtonPressed()
  {
  }

  @FXML private void manageRequirementDataButtonPressed()
  {
  }

  @FXML private void addRequirementButtonPressed()
  {
  }
}
