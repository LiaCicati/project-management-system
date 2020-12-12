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

public class AddEditProjectViewController
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
    private ProjectListViewModel projectListViewModel;
    private ViewHandler viewHandler;
    private ViewState viewState;

    public AddEditProjectViewController()
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
        if (viewState.getSelectedProject() > -1)
        {
            Project project = model.getAllProjects()
                .getProjectById(viewState.getSelectedProject());
            projectTitleInput.setText(project.getTitle());
            projectCustomerIDInput.setText(project.getCustomerID() + "");
            projectDescriptionInput.setText(project.getDescription());
            deadlineInput.setAccessibleText(project.getDeadline() + "");
            statusInput.setAccessibleText(project.getStatus());
        }
        else
        {
            this.errorLabel.setText("");
            this.projectTitleInput.setText("");
            this.projectCustomerIDInput.setText("");
            this.projectDescriptionInput.setText("");
            this.deadlineInput.getEditor().clear();
            this.statusInput.getSelectionModel().clearAndSelect(0);
        }
    }

    public Region getRoot()
    {
        return root;
    }

    @FXML private void addProjectSaveButton()
    {
        try
        {
            if (projectTitleInput.getText().equals(""))
                throw new IllegalArgumentException("Title cannot be empty");
            String title = projectTitleInput.getText();

            int customerID;
            if (projectCustomerIDInput.getText().equals(""))
                throw new IllegalArgumentException(
                    "Customer ID can not be empty");
            try
            {
                customerID = Integer.parseInt(projectCustomerIDInput.getText());
            }
            catch (NumberFormatException e)
            {
                throw new IllegalArgumentException(
                    "Customer ID should be a number");
            }
            if (projectDescriptionInput.getText().equals(""))
                throw new IllegalArgumentException(
                    "A description should be added to the project");
            String description = projectDescriptionInput.getText();
            if (deadlineInput.getValue() == null)
            {
                errorLabel.setText("A deadline should be added to the project");
                throw new IllegalStateException(errorLabel.getText());
            }
            LocalDate today = LocalDate.now();
            if (deadlineInput.getValue().isBefore(today))
                throw new IllegalArgumentException(
                    "Deadline can not be set in the past");
            int day = deadlineInput.getValue().getDayOfMonth();
            int month = deadlineInput.getValue().getMonthValue();
            int year = deadlineInput.getValue().getYear();
            MyDate deadline = new MyDate(day, month, year);

            Project project = new Project(title, deadline, customerID,
                description);
            String status = null;
            switch (statusInput.getValue())
            {
                case "Started":
                    status = Project.STARTED;
                    break;
                case "Ended":
                    status = Project.ENDED;
                    break;
                case "Not Started":
                    status = Project.NOT_STARTED;
                    break;
            }
            if (viewState.getSelectedProject() > -1)
            {
                model.editProject(viewState.getSelectedProject(), title,
                    customerID, description, deadline, status);
            }

            else
            {
                model.addProject(project);
            }
            errorLabel.setText("");
            reset();
            viewHandler.openView("projectList");
            projectListViewModel.update();
        }
        catch (Exception e)
        {
            errorLabel.setText(e.getMessage());
        }
    }

    @FXML private void cancelButtonPressed()
    {
        reset();
        viewHandler.openView("projectList");
    }
}