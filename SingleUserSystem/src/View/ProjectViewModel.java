package View;

import Model.MyDate;
import Model.Project;
import javafx.beans.property.*;

public class ProjectViewModel
{
  private StringProperty titleProperty;
  private IntegerProperty customerIDProperty;
  private StringProperty descriptionProperty;
  private StringProperty deadlineProperty;
  private StringProperty statusProperty;

  public ProjectViewModel(Project project)
  {
    titleProperty = new SimpleStringProperty(project.getTitle());
    customerIDProperty = new SimpleIntegerProperty(project.getCustomerID());
    descriptionProperty = new SimpleStringProperty(project.getDescription());
    deadlineProperty = new SimpleStringProperty(
        project.getDeadline().toString());
    statusProperty = new SimpleStringProperty(project.getStatus());
  }

  public StringProperty getTitleProperty()
  {
    return titleProperty;
  }

  public IntegerProperty getCustomerIDProperty()
  {
    return customerIDProperty;
  }

  public StringProperty getDescriptionProperty()
  {
    return descriptionProperty;
  }

  public StringProperty getDeadlineProperty()
  {
    return deadlineProperty;
  }

  public StringProperty getStatusProperty()
  {
    return statusProperty;
  }
}

