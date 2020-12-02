package Model;

public class Functional extends Requirement
{
  private String who;
  private String what;
  private String why;

  public Functional(int ID, double estimatedTime,
      TeamMember responsibleTeamMember, MyDate deadline, String who,
      String what, String why)
  {
    super(ID, estimatedTime, responsibleTeamMember, deadline);
    setWho(who);
    setWhat(what);
    setWhy(why);
  }

  public void setWho(String who)
  {
    this.who = who;
  }

  public void setWhat(String what)
  {
    this.what = what;
  }

  public void setWhy(String why)
  {
    this.why = why;
  }
}
