package View;

import Mediator.ProjectManagementModel;
import Model.Project;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import Model.TeamMember;

public class TeamMemberViewModel
{
    private StringProperty nameProperty;
    private IntegerProperty idProperty;
    private StringProperty roleProperty;

    public TeamMemberViewModel(TeamMember teamMember)
    {
        nameProperty = new SimpleStringProperty(
            String.valueOf(teamMember.getName()));
        idProperty = new SimpleIntegerProperty(teamMember.getId());
        roleProperty = new SimpleStringProperty(teamMember.getRole());
    }


    public StringProperty getNameProperty()
    {
        return nameProperty;
    }

    public IntegerProperty getIdProperty()
    {
        return idProperty;
    }

    public StringProperty getRoleProperty()
    {
        return roleProperty;
    }
}
