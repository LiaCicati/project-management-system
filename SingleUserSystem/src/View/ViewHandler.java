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

    private Region loadAddEditRequirementView(String fxmlFile, ViewState viewState)
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

    private Region loadManageRequirementDataView(String fxmlFile, ViewState viewState)
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
}