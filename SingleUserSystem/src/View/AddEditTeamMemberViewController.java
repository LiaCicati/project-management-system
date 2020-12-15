package View;

import Mediator.ProjectManagementModel;
import Model.*;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

import java.time.LocalDate;

public class AddEditTeamMemberViewController
{
    @FXML private TextField firstNameInput;
    @FXML private TextField lastNameInput;
    @FXML private TextField teamMemberIDInput;
    @FXML private ChoiceBox<String> rolesInput;
    @FXML private Label errorLabel;
    @FXML private Button saveTeamMember;

    private Region root;
    private ProjectManagementModel model;
    private TeamMemberListViewModel teamMemberListViewModel;
    private ViewHandler viewHandler;
    private ViewState viewState;

    public AddEditTeamMemberViewController()
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
        errorLabel.setText("");
    }

    public void reset()
    {
        if (viewState.getSelectedTeamMember() > -1)
        {
            TeamMember teamMember = model.getAllProjects()
                .getProjectById(viewState.getSelectedProject())
                .getTeamMemberByID(viewState.getSelectedTeamMember());
            firstNameInput.setText(teamMember.getName().getFirstName());
            lastNameInput.setText(teamMember.getName().getLastName());
            teamMemberIDInput.setEditable(false);
            teamMemberIDInput.setText(String.valueOf(teamMember.getId()));
            rolesInput.setAccessibleText(teamMember.getRole());
        }
        else
        {
            this.errorLabel.setText("");
            this.firstNameInput.setText("");
            this.lastNameInput.setText("");
            this.teamMemberIDInput.setText("");
            this.rolesInput.getSelectionModel().clearAndSelect(0);
        }
    }

    public Region getRoot()
    {
        return root;
    }

    @FXML private void addTeamMemberSaveButton()
    {
        try
        {
            if (firstNameInput.getText().equals("") || lastNameInput.getText()
                .equals(""))
                throw new IllegalArgumentException("Name cannot be empty");
            String firstName = firstNameInput.getText();
            String lastName = lastNameInput.getText();
            Name name = new Name(firstName, lastName);

            int teamMemberID;
            if (teamMemberIDInput.getText().equals(""))
                throw new IllegalArgumentException(
                    "Team member ID can not be empty");
            try
            {
                teamMemberID = Integer.parseInt(teamMemberIDInput.getText());
            }
            catch (NumberFormatException e)
            {
                throw new IllegalArgumentException(
                    "Team member ID should be a number");
            }

            TeamMember teamMember = new TeamMember(name, teamMemberID);
            TeamMember productOwner = new ProductOwner(name, teamMemberID);
            TeamMember scrumMaster = new ScrumMaster(name, teamMemberID);
            String role = null;
            switch (rolesInput.getValue())
            {
                case "Team Member":
                    role = teamMember.getRole();
                    break;
                case "Product Owner":
                    role = productOwner.getRole();
                    break;
                case "Scrum Master":
                    role = scrumMaster.getRole();
                    break;
            }
            teamMember.changeRole(role);

            if (viewState.getSelectedTeamMember() > -1)
            {
                model.editTeamMember(viewState.getSelectedProject(),
                    teamMemberID, teamMember, role);
            }
            else
            {
                model.addTeamMember(viewState.getSelectedProject(), teamMember);
            }
            errorLabel.setText("");
            reset();
            viewHandler.openView("manageProjectData");
            teamMemberListViewModel.update();
        }
        catch (Exception e)
        {
            errorLabel.setText(e.getMessage());
        }
    }

    @FXML private void cancelButtonPressed()
    {
        viewHandler.openView("manageProjectData");
    }
}

