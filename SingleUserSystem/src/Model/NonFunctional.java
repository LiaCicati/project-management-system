package Model;

public class NonFunctional extends Requirement
{
  private String what;

  public NonFunctional(int ID, double estimatedTime,
      TeamMember responsibleTeamMember, MyDate deadline, String what)
  {
    super(ID, estimatedTime, responsibleTeamMember, deadline);
    setWhat(what);
  }

  public void setWhat(String what)
  {
    this.what = what;
  }
}
