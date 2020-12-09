package View;

import Mediator.ProjectManagementModel;
import Model.MyDate;
import Model.Project;
import Model.ProjectList;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

import java.time.LocalDate;

public class EditProjectViewController
{
  @FXML private TextField projectTitleInput;

  @FXML private TextArea projectDescriptionInput;
  @FXML private TextField projectCustomerIDInput;
  @FXML private ChoiceBox<String> statusInput;
  @FXML private DatePicker deadlineInput;

  @FXML private Label errorLabel;
  @FXML private Button saveProject;

  private Region root;
  private ProjectManagementModel model;
  private ViewHandler viewHandler;
  private ViewState viewState;

  public EditProjectViewController()
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
    //    saveProject.setDisable(true);
    errorLabel.setText("");
  }

  public void reset()
  {
    this.errorLabel.setText("");
    this.projectTitleInput.setText("");
    this.projectCustomerIDInput.setText("");
    this.projectDescriptionInput.setText("");
    this.deadlineInput.getEditor().clear();
    this.statusInput.getSelectionModel().clearAndSelect(0);
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void editProjectSaveButton()
  {

  }

  @FXML private void cancelButtonPressed()
  {
    reset();
    viewHandler.openView("projectList");
  }
}
