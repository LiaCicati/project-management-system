package Model;

/**
 * @author Siyu Xia
 * @version 3/12/2020
 */
public class TeamMember
{
  private int id;
  private Name name;

  /**
   *Contructor for the teammember
   * @param name the name of the teammember
   * @param id the id of the teammember
   */
  public TeamMember(Name name, int id)
  {
    this.name = name;
    setId(id);
  }

  /**
   *Getter for the teammember's name
   * @return the name of the teammember
   */
  public Name getName()
  {
    return name;
  }

  /**
   * Getter for the teammember's id
   * @return the id of the teammember
   */
  public int getId()
  {
    return id;
  }

  /**
   * Sets the id of a teammember
   * @param id the id
   */
  public void setId(int id)
  {
    this.id = id;
  }

  /**
   * Sets the name of a teammember
   * @param name the name
   */
  public void setName(Name name)
  {
    this.name=name;
  }

  /**
   * Checking if two teammembers are the same
   * @param obj the teammember compared to
   * @return true if the teammembers are the same or false if not
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof TeamMember))
    {
      return false;
    }
    TeamMember other = (TeamMember) obj;
    return id == other.id && name.equals(other.name);
  }

  /**
   * Getting the information about a teammember
   * @return a string with all needed information about a teammember
   */
  public String toString()
  {
    return "ID: " + id + ", Full name: " + name;
  }
}
