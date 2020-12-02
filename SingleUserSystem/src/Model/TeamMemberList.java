package Model;

import java.util.ArrayList;

public class TeamMemberList
{
  private ArrayList<TeamMember> teamMembers;

  public TeamMemberList()
  {
    this.teamMembers = new ArrayList<>();
  }

  public ArrayList<TeamMember> getAllTeamMembers()
  {
    return teamMembers;
  }

  public void addTeamMember(TeamMember teamMember)
  {
    teamMembers.add(teamMember);
  }

  public void removeTeamMember(TeamMember teamMember)
  {
    teamMembers.remove(teamMember);
  }

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

  public TeamMember getTeamMemberById(int id)
  {
    for (int i = 0; i < teamMembers.size(); i++)
    {
      if (teamMembers.get(i).getId() == id)
      {
        return teamMembers.get(i);
      }
    }
    return null;
  }

  public TeamMember get(int index)
  {
    return teamMembers.get(index);
  }

  public int getSize()
  {
    return teamMembers.size();
  }

  public String toString()
  {
    return "Team members: " + teamMembers;
  }
}
