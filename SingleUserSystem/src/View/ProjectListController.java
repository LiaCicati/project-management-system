package View;

import Mediator.ProjectManagementModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import Model.*;

import java.awt.event.MouseEvent;
import java.util.Optional;

/**
 * Controller for Project List View
 */
public class ProjectListController
{
  @FXML private TableView<ProjectViewModel> projectListTable;
  @FXML private TableColumn<ProjectViewModel, Number> projectCustomerIdColumn;
  @FXML private TableColumn<ProjectViewModel, String> projectTitleColumn;
  @FXML private TableColumn<ProjectViewModel, String> projectDescriptionColumn;
  @FXML private TableColumn<ProjectViewModel, String> projectDeadlineColumn;
  @FXML private TableColumn<ProjectViewModel, String> projectStatusColumn;
  @FXML private Label errorLabel;
//  ObservableList<ProjectViewModel> list;
  private Region root;
  private ProjectManagementModel model;
  private ViewHandler viewHandler;
  private ViewState viewState;
  private ProjectListViewModel projectListViewModel;

  public ProjectListController()
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
    this.projectListViewModel = new ProjectListViewModel(model, viewState);

    projectTitleColumn.setCellValueFactory(
        cellData -> cellData.getValue().getTitleProperty());
    projectCustomerIdColumn.setCellValueFactory(
        cellData -> cellData.getValue().getCustomerIDProperty());
    projectDescriptionColumn.setCellValueFactory(
        cellData -> cellData.getValue().getDescriptionProperty());
    projectDeadlineColumn.setCellValueFactory(
        cellData -> cellData.getValue().getDeadlineProperty());
    projectStatusColumn.setCellValueFactory(
        cellData -> cellData.getValue().getStatusProperty());

    projectListTable.setItems(projectListViewModel.getList());
    errorLabel.setText("");
  }

  public void reset()
  {
    errorLabel.setText("");

    projectListViewModel.update();
  }

  public Region getRoot()
  {
    return root;
  }


  @FXML private void addProjectButtonPressed()
  {
    viewState.setSelectedProject(-1);
    viewHandler.openView("addEditProject");
  }


  @FXML private void editProjectButtonPressed()
  {
    try
    {
      ProjectViewModel selectedItem = projectListTable.getSelectionModel()
          .getSelectedItem();
      viewState
          .setSelectedProject(selectedItem.getCustomerIDProperty().get());
      viewHandler.openView("addEditProject");
    }
    catch (Exception e)
    {
      errorLabel.setText("Select a project from the list");
    }


  }

  private boolean confirmation()
  {
    int index = projectListTable.getSelectionModel().getSelectedIndex();
    ProjectViewModel selectedItem = projectListTable.getItems().get(index);
    if (index >= projectListTable.getItems().size())
    {
      return false;
    }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(
        "Are you sure you want to remove the following project: " + selectedItem
            .getTitleProperty().get() + "?");
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent() && (result.get() == ButtonType.OK));
  }

  @FXML private void removeProjectButton()
  {
    errorLabel.setText("");
    try
    {
      ProjectViewModel selectedItem = projectListTable.getSelectionModel()
          .getSelectedItem();
      boolean remove = confirmation();
      if (remove)
      {
        Project project = model.getAllProjects()
            .getProjectByTitle(selectedItem.getTitleProperty().get());
        model.removeProject(project);
        projectListViewModel.remove(project);
        projectListTable.getSelectionModel().clearSelection();
      }
    }
    catch (Exception e)
    {
      errorLabel.setText("Choose a project you want to remove from the list");
    }
  }

  @FXML private void manageProjectDataPressed()
  {
    try
    {
      ProjectViewModel selectedItem = projectListTable.getSelectionModel()
          .getSelectedItem();
      viewState
          .setSelectedProject(selectedItem.getCustomerIDProperty().getValue());
      viewHandler.openView("manageProjectData");
    }
    catch (Exception e)
    {
      errorLabel.setText("Select a project from the list");
    }
  }
}

