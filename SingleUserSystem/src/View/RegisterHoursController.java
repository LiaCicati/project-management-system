package View;

import Mediator.ProjectManagementModel;
import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.time.LocalDate;

public class RegisterHoursController
{
    @FXML private TextField teamMemberInput;
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

    public void init(ViewHandler viewHandler, ProjectManagementModel model,
        Region root, ViewState viewState)
    {
        this.model = model;
        this.viewHandler = viewHandler;
        this.teamMemberListViewModel = new TeamMemberListViewModel(model,
            viewState);
        this.viewState = viewState;
        this.root = root;
        reset();
    }

    public void reset()
    {
        errorLabel.setText("");
        Project project = model.getAllProjects()
            .getProjectById(viewState.getSelectedProject());
        Requirement requirement = model.getAllRequirements(project)
            .getByID(viewState.getSelectedRequirement());
        Task task = model.getAllTasks(model.getAllProjects()
            .getProjectById(viewState.getSelectedProject()), requirement)
            .getTaskByID(viewState.getSelectedTask());
        // should try to fix this part, so when register button is pressed the name of the team member will appear in the text field

        //  TeamMember teamMember = model.getAllTeam(project, requirement, task).getTeamMemberById(viewState.getSelectedTeamMember());
        //    this.teamMemberInput.setText(teamMember.getName() + "");
        teamMemberListViewModel.update();

    }

    public Region getRoot()
    {
        return root;
    }

    @FXML private void saveDataButtonPressed()
    {
        try
        {
            double hours;
            if (hoursWorked.getText().equals(""))
                throw new IllegalArgumentException(
                    "Worked hours cannot be empty");
            try
            {
                hours = Double.parseDouble(hoursWorked.getText());
            }
            catch (NumberFormatException e)
            {
                throw new IllegalArgumentException(
                    "Estimated time should be a number, indicating the hours, ex : 25.5");
            }
            // here should be a method from the model that will edit the data from the table
            System.out.println(viewState.getSelectedTeamMember());

            model.addHours(viewState.getSelectedProject(),
                viewState.getSelectedRequirement(), viewState.getSelectedTask(),
                viewState.getSelectedTeamMember(), hours);

            errorLabel.setText("");
            reset();
            viewHandler.openView("manageTaskData");
            teamMemberListViewModel.update();
        }
        catch (Exception e)
        {
            errorLabel.setText(e.getMessage());
        }
    }

    @FXML private void cancelDataButtonPressed()
    {
        viewHandler.openView("manageTaskData");
    }
}
