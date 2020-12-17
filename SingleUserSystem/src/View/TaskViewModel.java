package View;

import Model.Task;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TaskViewModel
{
  private IntegerProperty requirementIDProperty;
  private IntegerProperty taskIDProperty;
  private StringProperty taskTitleProperty;
  private StringProperty taskDescriptionProperty;
  private IntegerProperty taskEstimatedTimeProperty;
  private StringProperty taskResponsibleMemberProperty;
  private StringProperty taskDeadlineProperty;
  private StringProperty taskStatusProperty;
  private IntegerProperty hoursWorkedProperty;

  public TaskViewModel(Task task)
  {
    try
    {
      double estimatedTime = task.getEstimatedTime();
      double hoursWorked = task.getTimeSpent();
      requirementIDProperty = new SimpleIntegerProperty(task.getRequirementID());
      taskIDProperty = new SimpleIntegerProperty(task.getID());
      taskTitleProperty = new SimpleStringProperty(task.getTitle());
      taskDescriptionProperty = new SimpleStringProperty(task.getDescription());
      taskEstimatedTimeProperty = new SimpleIntegerProperty(((int) estimatedTime));
      taskResponsibleMemberProperty = new SimpleStringProperty(String.valueOf(task.getResponsibleTeamMember().getName()));
      taskDeadlineProperty = new SimpleStringProperty(
          task.getDeadline().toString());
      taskStatusProperty = new SimpleStringProperty(task.getStatus());
      hoursWorkedProperty = new SimpleIntegerProperty(((int) hoursWorked));
    }
    catch (NullPointerException e)
    {
      System.out.println(e.getMessage());
    }
  }

  public IntegerProperty getRequirementIDProperty()
  {
    return requirementIDProperty;
  }

  public IntegerProperty getTaskIDProperty()
  {
    return taskIDProperty;
  }

  public StringProperty getTaskTitleProperty()
  {
    return taskTitleProperty;
  }

  public StringProperty getTaskDescriptionProperty()
  {
    return taskDescriptionProperty;
  }

  public IntegerProperty getTaskEstimatedTimeProperty()
  {
    return taskEstimatedTimeProperty;
  }

  public StringProperty getTaskResponsibleMemberProperty()
  {
    return taskResponsibleMemberProperty;
  }

  public StringProperty getTaskDeadlineProperty()
  {
    return taskDeadlineProperty;
  }

  public StringProperty getTaskStatusProperty()
  {
    return taskStatusProperty;
  }

  public IntegerProperty getHoursWorkedProperty()
  {
    return hoursWorkedProperty;
  }
}
