package Model;

import java.util.ArrayList;

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
     * @param project project to be added
     */
    public void addProject(Project project)
    {
        projectList.add(project);
    }

    /**
     * Removes a project from the list
     * @param project project to be removed
     */
    public void removeProject(Project project)
    {
        projectList.remove(project);
    }

    /**
     * Getter for the number of projects
     * @return the number of projects
     */
    public int getNumberOfProjects()
    {
        return projectList.size();
    }

    /**
     * Getter for all projects
     * @return all projects
     */
    public ArrayList<Project> getAllProjects()
    {
        return projectList;
    }

    /**
     * Getter for a project with a given title
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
     * Getter for projects with a given customerID
     * @param customerID ID of the projects customer
     * @return the projects with the given customer ID
     */
    public ArrayList<Project> getProjectByCustomerID(int customerID)
    {
        ArrayList<Project> projectCustomerIDCheck = new ArrayList<>();
        for (Project project : projectList)
        {
            if (customerID == project.getCustomerID())
            {
                projectCustomerIDCheck.add(project);
            }
        }
        return projectCustomerIDCheck;
    }

    /**
     * Getter for a project by index
     * @param index index of the project
     * @return the project at the given index
     */
    public Project getProject(int index)
    {
        return projectList.get(index);
    }

    /**
     * A toString method for a list of projects
     * @return the projects in the list in the form of a String
     */
    @Override public String toString()
    {
        return "Projects: " + "\n" + projectList;
    }
}
