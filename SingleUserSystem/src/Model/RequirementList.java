package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

/**
 * @author
 * @version v.1 3d December 2020
 */
public class RequirementList
{
  private ArrayList<Requirement> requirements;

  /**
   * Constructor for the requirements
   */
  public RequirementList()
  {
    this.requirements = new ArrayList<>();
  }

  /**
   * Adding a requirement to a list of requirements
   *
   * @param requirement the added requirement
   */
  public void addRequirement(Requirement requirement)
  {
    requirements.add(requirement);
  }

  /**
   * Removing a requirement from the list
   *
   * @param requirement the removed requirement
   */
  public void removeRequirement(Requirement requirement)
  {
    requirements.remove(requirement);
  }

  /**
   * Getting all requirements
   *
   * @return an array list of all requirements
   */
  public ArrayList<Requirement> getRequirements()
  {
    return requirements;
  }

  /**
   * Getting a requirement from the list by its specific id
   *
   * @param ID the id of the requirement
   * @return the requirement with this specific id or null if nothing is found
   */
  public Requirement getByID(int ID)
  {
    try
    {
      for (int i = 0; i < requirements.size(); i++)
      {
        if (requirements.get(i).getID() == ID)
        {
          return requirements.get(i);
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
   * Getting a requirement by its responsible team member
   *
   * @param responsibleTeamMember the responsible team member for the requirement
   * @return an array list with all requirements that a specific team member is responsible for
   */
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

  /**
   * Getting all requirements with a specific deadline from the requirement's list
   *
   * @param deadline the deadline for the requirement
   * @return an array list with all requirements that correspond to a specific deadline
   */
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

  /**
   * Getting requirements from the list with a specific status
   *
   * @param status the status of the requirement
   * @return an array list with all requirements that have a specific status
   */
  public ArrayList<Requirement> getByStatus(String status)
  {
    ArrayList<Requirement> byStatus = new ArrayList<>();
    for (int i = 0; i < requirements.size(); i++)
    {
      if (requirements.get(i).getStatus().equals(status))
      {
        byStatus.add(requirements.get(i));
      }
    }
    return byStatus;
  }

  public void changeStatus(String status, Requirement requirement)
  {
    requirement.setStatus(status);
  }

  /**
   * Getting a requirement from the list at a specific index
   *
   * @param index the index of the requirement
   * @return the requirement at the specified index
   */
  public Requirement getRequirement(int index)
  {
    return requirements.get(index);
  }

  /**
   * Getting the total number of requirements from the list
   *
   * @return total number of requirements
   */
  public int getSize()
  {
    return requirements.size();
  }

  /**
   * Reorders positions in the requirement list
   *
   * @param position    position you wish to swap
   * @param newPosition position you wish to swap to
   */
  public void reorder(int position, int newPosition)
  {
    try
    {
      Collections.swap(requirements, position, newPosition);
    }
    catch (IndexOutOfBoundsException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Checking if requirements are in ended state
   * @return true if all requirements from the list are in ended state and false if not
   */
  public boolean areInEndedState()
  {
    for (int i = 0; i < requirements.size(); i++)
    {
      return requirements.get(i).isEnded();
    }
    return false;
  }

  /**
   * Getting the information about all requirements
   *
   * @return a string with all needed information about all requirements
   */
  @Override public String toString()
  {
    return "Requirements : " + "\n" + requirements;
  }

}