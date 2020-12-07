package Model;

import java.util.InputMismatchException;

/**
 * @author Siyu Xia
 * @version 3/12/2020
 */
public class TeamMember
{
  private int id;
  private Name name;
  private String role;

  /**
   * Constructor for the team member
   *
   * @param name the name of the team member
   * @param id   the id of the team member
   */
  public TeamMember(Name name, int id)
  {
    this.name = name;
    this.role = "Team member";
    setId(id);
  }

  /**
   * Getter for the team member's name
   *
   * @return the name of the team member
   */
  public Name getName()
  {
    return name;
  }

  public String getRole() {
    return role;
  }

  /**
   * Getter for the team member's id
   *
   * @return the id of the team member
   */
  public int getId()
  {
    return id;
  }

  /**
   * Sets the id of a team member
   *
   * @param id the id
   */
  public void setId(int id)
  {
    try
    {
      this.id = id;
    }
    catch (InputMismatchException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Sets the name of a team member
   *
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
    try
    {
      task.setTimeSpent(timeSpent);
    }
    catch (InputMismatchException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Checking if two team members are the same
   *
   * @param obj the team member compared to
   * @return true if the team members are the same or false if not
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
   * Getting the information about a team member
   *
   * @return a string with all needed information about a team member
   */
  public String toString()
  {
    return "ID: " + id + ", Full name: " + name + ", Role: " + getRole();
  }
}
