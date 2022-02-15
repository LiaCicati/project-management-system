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
  private AddEditTeamMemberViewController addEditTeamMemberViewController;
  private AddEditRequirementViewController addEditRequirementViewController;
  private ManageRequirementDataViewController manageRequirementDataViewController;
  private AddEditTaskViewController addEditTaskViewController;
  private ManageTaskDataViewController manageTaskDataViewController;
  private RegisterHoursController registerHoursController;

  public ViewHandler(ProjectManagementModel model)
  {
    this.model = model;
    // Instantiating the Scene class by passing the root object to the constructor of the scene class
    currentScene = new Scene(new Region());
    this.viewState = new ViewState();
  }

  public void start(Stage primaryStage)
  {
    // Setting the stage
    this.primaryStage = primaryStage;
    // Opening the first window
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
      case "addEditTeamMember":
        root = loadAddEditTeamMemberView("AddEditTeamMemberView.fxml",
            viewState);
        break;
      case "addEditRequirement":
        root = loadAddEditRequirementView("AddEditRequirementView.fxml",
            viewState);
        break;
      case "manageRequirementData":
        root = loadManageRequirementDataView("ManageRequirementDataView.fxml",
            viewState);
        break;
      case "addEditTask":
        root = loadAddEditTaskView("AddEditTaskView.fxml", viewState);
        break;
      case "manageTaskData":
        root = loadManageTaskDataView("ManageTaskDataView.fxml", viewState);
        break;
      case "registerHours":
        root = loadRegisterHoursView("RegisterHoursView.fxml", viewState);
        break;

    }
    // Adding the Scene Graph
    currentScene.setRoot(root);
    String title = "";
    assert root != null;
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    // Preparing the Stage
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    // Setting the dimensions of the Stage
    primaryStage.setMinWidth(root.getPrefWidth());
    primaryStage.setMinHeight(root.getPrefHeight());
    primaryStage.show(); // displaying the contents of the Stage
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

  private Region loadAddEditTeamMemberView(String fxmlFile, ViewState viewState)
  {
    if (addEditTeamMemberViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        addEditTeamMemberViewController = loader.getController();
        addEditTeamMemberViewController.init(this, model, root, viewState);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      addEditTeamMemberViewController.reset();
    }
    return addEditTeamMemberViewController.getRoot();
  }

  private Region loadAddEditRequirementView(String fxmlFile,
      ViewState viewState)
  {
    if (addEditRequirementViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        addEditRequirementViewController = loader.getController();
        addEditRequirementViewController.init(this, model, root, viewState);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      addEditRequirementViewController.reset();
    }
    return addEditRequirementViewController.getRoot();
  }

  private Region loadManageRequirementDataView(String fxmlFile,
      ViewState viewState)
  {
    if (manageRequirementDataViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        manageRequirementDataViewController = loader.getController();
        manageRequirementDataViewController.init(this, model, root, viewState);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      manageRequirementDataViewController.reset();
    }
    return manageRequirementDataViewController.getRoot();
  }

  private Region loadAddEditTaskView(String fxmlFile, ViewState viewState)
  {
    if (addEditTaskViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        addEditTaskViewController = loader.getController();
        addEditTaskViewController.init(this, model, root, viewState);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      addEditTaskViewController.reset();
    }
    return addEditTaskViewController.getRoot();
  }

  private Region loadManageTaskDataView(String fxmlFile, ViewState viewState)
  {
    if (manageTaskDataViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        manageTaskDataViewController = loader.getController();
        manageTaskDataViewController.init(this, model, root, viewState);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      manageTaskDataViewController.reset();
    }
    return manageTaskDataViewController.getRoot();
  }

  private Region loadRegisterHoursView(String fxmlFile, ViewState viewState)
  {
    if (registerHoursController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        registerHoursController = loader.getController();
        registerHoursController.init(this, model, root, viewState);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      registerHoursController.reset();
    }
    return registerHoursController.getRoot();
  }
}