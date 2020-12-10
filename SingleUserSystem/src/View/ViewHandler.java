package View;

import Mediator.ProjectManagementModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private ProjectManagementModel model;
  private ViewState viewState;
  /**
   * Controllers
   */
  private ProjectListController projectListViewController;
  private AddEditProjectViewController addEditProjectViewController;
  private ManageProjectDataController manageProjectDataController;

  public ViewHandler(ProjectManagementModel model)
  {
    this.model = model;
    currentScene = new Scene(new Region());
    this.viewState = new ViewState();
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("projectList");
  }

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "projectList":
        root = loadProjectListView("ProjectListView.fxml", viewState);
        break;
      case "addEditProject":
        root = loadAddEditProjectView("AddEditProjectView.fxml", viewState);
        break;
      case "manageProjectData":
        root = loadManageProjectDataView("ManageProjectDataView.fxml",
            viewState);
        break;
    }
    currentScene.setRoot(root);
    String title = "";
    assert root != null;
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setMinWidth(root.getPrefWidth());
    primaryStage.setMinHeight(root.getPrefHeight());
    primaryStage.show();
  }

  public void closeView()
  {
    primaryStage.close();
  }

  private Region loadProjectListView(String fxmlFile, ViewState viewState)
  {
    if (projectListViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        projectListViewController = loader.getController();
        projectListViewController.init(this, model, root, viewState);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      projectListViewController.reset();
    }
    return projectListViewController.getRoot();
  }

  private Region loadAddEditProjectView(String fxmlFile, ViewState viewState)
  {
    if (addEditProjectViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        addEditProjectViewController = loader.getController();
        addEditProjectViewController.init(this, model, root, viewState);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      addEditProjectViewController.reset();
    }
    return addEditProjectViewController.getRoot();
  }



  private Region loadManageProjectDataView(String fxmlFile, ViewState viewState)
  {
    if (manageProjectDataController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        manageProjectDataController = loader.getController();
        manageProjectDataController.init(this, model, root, viewState);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      manageProjectDataController.reset();
    }
    return manageProjectDataController.getRoot();
  }
}