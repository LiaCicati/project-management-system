package Model;

/**
 * @version v.2 7th December
 */
public class ScrumMaster extends TeamMember
{
  /**
   * Constructor for the scrum master member
   *
   * @param name the name of the scrum master
   * @param id   the id of the scrum master
   */
  public ScrumMaster(Name name, int id)
  {
    super(name, id);
  }

  /**
   * Getter for the role of the team member
   *
   * @return the role
   */
  public String getRole()
  {
    return "Scrum Master";
  }
}
