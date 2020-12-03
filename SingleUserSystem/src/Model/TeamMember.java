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
   <<<<<<< Updated upstream
   * Contructor for the team member
   *
   * @param name the name of the team member
   * @param id   the id of the team member
  =======
   *Contructor for the teammember
   * @param name the name of the teammember
   * @param id the id of the teammember
  >>>>>>> Stashed changes
   */
  public TeamMember(Name name, int id)
  {
    this.name = name;
    setId(id);
  }

  /**
   <<<<<<< Updated upstream
   * Getter for the team member's name
   *
   * @return the name of the team member
  =======
   *Getter for the teammember's name
   * @return the name of the teammember
  >>>>>>> Stashed changes
   */
  public Name getName()
  {
    return name;
  }

  /**
   <<<<<<< Updated upstream
   * Getter for the team member's id
   *
   * @return the id of the team member
  =======
   * Getter for the teammember's id
   * @return the id of the teammember
  >>>>>>> Stashed changes
   */
  public int getId()
  {
    return id;
  }

  /**
   <<<<<<< Updated upstream
   * Sets the id of a team member
   *
   =======
   * Sets the id of a teammember
   >>>>>>> Stashed changes
   * @param id the id
   */
  public void setId(int id)
  {
    this.id = id;
  }

  /**
   <<<<<<< Updated upstream
   * Sets the name of a team member
   *
   =======
   * Sets the name of a teammember
   >>>>>>> Stashed changes
   * @param name the name
   */
  public void setName(Name name)
  {
    this.name = name;
  }

  /**
   * Register time spent on a specific task
   *
   * @param timeSpent the time spent on the task
   * @param task      the task the time is registered to
   */
  public void registerTime(double timeSpent, Task task)
  {
    task.setTimeSpent(timeSpent);
  }

  /**
   <<<<<<< Updated upstream
   * Checking if two team members are the same
   *
   * @param obj the team member compared to
   * @return true if the team members are the same or false if not
  =======
   * Checking if two teammembers are the same
   * @param obj the teammember compared to
   * @return true if the teammembers are the same or false if not
  >>>>>>> Stashed changes
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
   <<<<<<< Updated upstream
   * Getting the information about a team member
   *
   * @return a string with all needed information about a team member
  =======
   * Getting the information about a teammember
   * @return a string with all needed information about a teammember
  >>>>>>> Stashed changes
   */
  public String toString()
  {
    return "ID: " + id + ", Full name: " + name;
  }
}