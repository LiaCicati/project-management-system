package Model;

public class Functional extends Requirement
{
  private String description;

  public Functional(int ID, double estimatedTime,
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
    return "Functional";
  }

  @Override public String toString()
  {
    return super.toString() + "User story: " + description;
  }
}
