package View;

import Model.MyDate;
import Model.Requirement;
import javafx.beans.property.*;

public class RequirementViewModel
{
  private IntegerProperty requirementIDProperty;
  private StringProperty userStoryProperty;
  private StringProperty typeProperty;
  private IntegerProperty estimatedTimeProperty;
  private StringProperty deadlineProperty;
  private StringProperty responsibleTeamMemberProperty;
  private StringProperty statusProperty;
  private IntegerProperty hoursWorkedProperty;

  public RequirementViewModel(Requirement requirement)
  {

    double estimatedTime = requirement.getEstimatedTime();
    double hoursWorked = requirement.getTimeSpent();

    requirementIDProperty = new SimpleIntegerProperty(requirement.getID());
    userStoryProperty = new SimpleStringProperty(requirement.getUserStory());
    typeProperty = new SimpleStringProperty(requirement.getType().toString());
    estimatedTimeProperty = new SimpleIntegerProperty(((int) estimatedTime));
    deadlineProperty = new SimpleStringProperty(
        requirement.getDeadline().toString());
    responsibleTeamMemberProperty = new SimpleStringProperty(
        String.valueOf(requirement.getResponsibleTeamMember().getName()));
    statusProperty = new SimpleStringProperty(requirement.getStatus());
    hoursWorkedProperty = new SimpleIntegerProperty(((int) hoursWorked));

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

  public StringProperty getUserStoryProperty()
  {
    return userStoryProperty;
  }

  public StringProperty getTypeProperty()
  {
    return typeProperty;
  }

  public StringProperty getStatusProperty() {
    return statusProperty;
  }
  public IntegerProperty getHoursWorkedProperty()
  {
    return hoursWorkedProperty;
  }
}