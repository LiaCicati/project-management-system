package Model;
public class ScrumMaster extends TeamMember
{
  public ScrumMaster(Name name,int id)
  {
    super(name, id);
  }

  public String getRole()
  {
    return "Scrum Master";
  }
}
