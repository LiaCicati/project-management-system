package Model;

import java.util.ArrayList;

public class RequirementList
{
  private ArrayList<Requirement> requirements;

  public RequirementList()
  {
    this.requirements = new ArrayList<>();
  }

  public void addRequirement(Requirement requirement)
  {
    requirements.add(requirement);
  }

  public void removeRequirement(Requirement requirement)
  {
    requirements.remove(requirement);
  }

  public ArrayList<Requirement> getRequirements()
  {
    return requirements;
  }

  public Requirement getByID(int ID)
  {
    for (int i = 0; i < requirements.size(); i++)
    {
      if (requirements.get(i).getID() == ID)
      {
        return requirements.get(i);
      }
    }
    return null;
  }

  public ArrayList<Requirement> getByResponsibleTeamMember(
      TeamMember responsibleTeamMember)
  {
    ArrayList<Requirement> byResponsibleTeamMember = new ArrayList<>();
    for (int i = 0; i < requirements.size(); i++)
    {
      if (requirements.get(i).getResponsibleTeamMember()
          .equals(responsibleTeamMember))
      {
        byResponsibleTeamMember.add(requirements.get(i));
      }
    }
    return byResponsibleTeamMember;
  }

  public ArrayList<Requirement> getByDeadline(MyDate deadline)
  {
    ArrayList<Requirement> byDeadline = new ArrayList<>();
    for (int i = 0; i < requirements.size(); i++)
    {
      if (requirements.get(i).getDeadline() == deadline)
      {
        byDeadline.add(requirements.get(i));
      }
    }
    return byDeadline;
  }

  public Requirement getRequirement(int index)
  {
    return requirements.get(index);
  }

  public int getSize()
  {
    return requirements.size();
  }

  @Override public String toString()
  {
    return "Requirements : " + requirements;
  }

}
