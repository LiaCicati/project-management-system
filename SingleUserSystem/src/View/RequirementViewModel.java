package View;

import Model.MyDate;
import Model.Requirement;
import javafx.beans.property.*;

public class RequirementViewModel
{
  private IntegerProperty requirementIDProperty;
  private IntegerProperty estimatedTimeProperty;
  private StringProperty deadlineProperty;
  private StringProperty responsibleTeamMemberProperty;

  public RequirementViewModel(Requirement requirement)
  {
    Double a = requirement.getEstimatedTime();
    int estimatedTime = Integer.parseInt(String.valueOf(a));
    // Converts Estimated time of double type to int type

    requirementIDProperty = new SimpleIntegerProperty(requirement.getID());
    estimatedTimeProperty = new SimpleIntegerProperty(estimatedTime);
    deadlineProperty = new SimpleStringProperty(
        requirement.getDeadline().toString());
    responsibleTeamMemberProperty = new SimpleStringProperty(
        String.valueOf(requirement.getResponsibleTeamMember().getName()));
  }

  public IntegerProperty getRequirementIDProperty()
  {
    return requirementIDProperty;
  }

  public IntegerProperty getEstimatedTimeProperty()
  {
    return estimatedTimeProperty;
  }

  public StringProperty getDeadlineProperty()
  {
    return deadlineProperty;
  }

  public StringProperty getResponsibleTeamMemberProperty()
  {
    return responsibleTeamMemberProperty;
  }
}