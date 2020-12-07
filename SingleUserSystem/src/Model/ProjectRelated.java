package Model;

public class ProjectRelated extends Requirement
{
  private String description;

  public ProjectRelated(int ID, double estimatedTime,
      TeamMember responsibleTeamMember, MyDate deadline, String description)
  {
    super(ID, estimatedTime, responsibleTeamMember, deadline);
    setDescription(description);
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String getType()
  {
    return "Project Related";
  }

  @Override public String toString()
  {
    return super.toString() + "User story: " + description;
  }
}
