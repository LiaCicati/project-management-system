package View;

import javafx.beans.property.*;
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
