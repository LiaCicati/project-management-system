package View;

import Model.MyDate;
import Model.Requirement;
import javafx.beans.property.*;

public class RequirementViewModel
{
    private IntegerProperty requirementIDProperty;
    private IntegerProperty estimatedtimeProperty;
    private StringProperty deadlineProperty;
    private StringProperty responsibleteammemberProperty;

    public RequirementViewModel(Requirement requirement)
    {
      Double a = requirement.getEstimatedTime();
      int b = new Double(a).intValue();
      // Converts Estimated time of double type to int type

      requirementIDProperty = new SimpleIntegerProperty(requirement.getID());
      estimatedtimeProperty = new SimpleIntegerProperty(b);
      deadlineProperty = new SimpleStringProperty(requirement.getDeadline().toString());
      responsibleteammemberProperty = new SimpleStringProperty(String.valueOf(requirement.getResponsibleTeamMember().getName()));
    }

    public IntegerProperty getRequirementIDProperty()
    {
      return requirementIDProperty;
    }

    public IntegerProperty getEstimatedtimeProperty()
    {
      return estimatedtimeProperty;
    }

    public StringProperty getDeadlineProperty()
    {
      return deadlineProperty;
    }

    public StringProperty getResponsibleteammemberProperty()
    {
      return responsibleteammemberProperty;
    }
    }
