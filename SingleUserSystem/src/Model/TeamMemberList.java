package Model;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class TeamMemberList
{
  private ArrayList<TeamMember> teamMembers;

  /**
   * Zero argument constructor to initialize the ArrayList
   */
  public TeamMemberList()
  {
    this.teamMembers = new ArrayList<>();
  }

  /**
   * Getting all team members from the list
   * @return an array list of all team members
   */
  public ArrayList<TeamMember> getAllTeamMembers()
  {
    return teamMembers;
  }

  /**
   * Adding a team member to the list
   * @param teamMember the added team member
   */
  public void addTeamMember(TeamMember teamMember)
  {
    teamMembers.add(teamMember);
  }

  /**
   * Removing a team member from the list
   * @param teamMember the removed team member
   */
  public void removeTeamMember(TeamMember teamMember)
  {
    teamMembers.remove(teamMember);
  }

  /**
   * Getting a team member by its name
   * @param name the name of the team member
   * @return the team member with the specified name or null if there is no such team member in the list
   */
  public TeamMember getTeamMemberByName(Name name)
  {
    for (int i = 0; i < teamMembers.size(); i++)
    {
      if (teamMembers.get(i).getName().equals(name))
      {
        return teamMembers.get(i);
      }
    }
    return null;
  }

  /**
   * Getting the team member by a specified id
   * @param id the id belonging to the team member
   * @return the team member with the specified id or null if there is no such team member in the list
   */
  public TeamMember getTeamMemberById(int id)
  {
    try
    {
      for (int i = 0; i < teamMembers.size(); i++)
      {
        if (teamMembers.get(i).getId() == id)
        {
          return teamMembers.get(i);
        }
      }
    }
    catch (InputMismatchException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Getting a team member at a specific index
   * @param index the specified index
   * @return the team member at the specified index
   */
  public TeamMember get(int index)
  {
    return teamMembers.get(index);
  }

  /**
   * Getting the total number of team members that belong to the list
   * @return total number of team members from the list
   */
  public int getSize()
  {
    return teamMembers.size();
  }

  /**
   * Getting the information about team members
   * @return an array list including all data about team members
   */
  public String toString()
  {
    return "Team members: " + teamMembers;
  }
}
