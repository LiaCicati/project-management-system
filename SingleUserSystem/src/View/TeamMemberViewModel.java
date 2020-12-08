package View;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import Model.TeamMember;

public class TeamMemberViewModel
{
  private StringProperty nameProperty;
  private IntegerProperty idProperty;

  public TeamMemberViewModel(TeamMember teamMember)
  {

    nameProperty = new SimpleStringProperty(String.valueOf(teamMember.getName()));

    idProperty = new SimpleIntegerProperty(teamMember.getId());
  }

  public StringProperty getNameProperty(){return nameProperty;}
  public IntegerProperty getIdProperty(){return idProperty;}
}
