package Model;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * @author Rickie Nielsen
 * @version v.1 : 03/12/2020
 */
public class ProjectList
{
  private ArrayList<Project> projectList;

  /**
   * Zero argument constructor to initialize the ArrayList
   */
  public ProjectList()
  {
    this.projectList = new ArrayList<>();
  }

  /**
   * Adds a project to the list
   *
   * @param project project to be added
   */
  public void addProject(Project project)
  {
    for (int i = 0; i < projectList.size(); i++)
      if (projectList.get(i).getTitle().equals(project.getTitle()))
      {
        throw new IllegalArgumentException(
            "A project with this title already exists");
      }
      else if (projectList.get(i).getCustomerID() == project.getCustomerID())
      {
        throw new IllegalArgumentException(
            "A project with this ID already exists");
      }
    projectList.add(project);
  }

  /**
   * Removes a project from the list
   *
   * @param project project to be removed
   */
  public void removeProject(Project project)
  {
    projectList.remove(project);
  }

  /**
   * Getter for the number of projects
   *
   * @return the number of projects
   */
  public int getNumberOfProjects()
  {
    return projectList.size();
  }

  /**
   * Getter for all projects
   *
   * @return all projects
   */
  public ArrayList<Project> getAllProjects()
  {
    return projectList;
  }

  /**
   * Getter for a project with a given title
   *
   * @param title title of the project
   * @return the project with the given title
   */
  public Project getProjectByTitle(String title)
  {
    for (Project project : projectList)
    {
      if (title.equals(project.getTitle()))
      {
        return project;
      }
    }
    return null;
  }

  /**
   * Getter for projects with a given deadline
   *
   * @param deadline deadline for the project
   * @return the projects with the given deadline
   */
  public ArrayList<Project> getProjectByDeadline(MyDate deadline)
  {
    ArrayList<Project> projectDeadlineCheck = new ArrayList<>();
    for (Project project : projectList)
    {
      if (deadline.equals(project.getDeadline()))
      {
        projectDeadlineCheck.add(project);
      }
    }
    return projectDeadlineCheck;
  }

  /**
   * Getter for projects with a given status
   *
   * @param status status of the projects
   * @return the projects with the given status
   */
  public ArrayList<Project> getProjectByStatus(String status)
  {
    ArrayList<Project> projectStatusCheck = new ArrayList<>();
    for (Project project : projectList)
    {
      if (status.equals(project.getStatus()))
      {
        projectStatusCheck.add(project);
      }
    }
    return projectStatusCheck;
  }

  /**
   * Gets a project by its id from the list
   *
   * @param id the id
   * @return the project by its id or null if not found
   */
  public Project getProjectById(int id)
  {
    for (Project project : projectList)
    {
      if (project.getCustomerID() == id)
      {
        return project;
      }
    }
    return null;
  }

  /**
   * Getter for projects with a given customerID
   *
   * @param customerID ID of the projects customer
   * @return the projects with the given customer ID
   */
  public ArrayList<Project> getProjectByCustomerID(int customerID)
  {
    ArrayList<Project> projectCustomerIDCheck = new ArrayList<>();

    try
    {
      for (Project project : projectList)
      {
        if (customerID == project.getCustomerID())
        {
          projectCustomerIDCheck.add(project);
        }
      }
    }
    catch (InputMismatchException e)
    {
      e.printStackTrace();
    }
    return projectCustomerIDCheck;
  }

  /**
   * Getter for a project by index
   *
   * @param index index of the project
   * @return the project at the given index
   */
  public Project getProject(int index)
  {
    return projectList.get(index);
  }

  /**
   * A toString method for a list of projects
   *
   * @return the projects in the list in the form of a String
   */
  @Override public String toString()
  {
    return "Projects: " + "\n" + projectList;
  }
}
