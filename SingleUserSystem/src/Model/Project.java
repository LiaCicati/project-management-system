package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

/**
 * @author Rickie Nielsen
 * @version v.1 : 03/12/2020
 */
public class Project
{
    private String title;
    private String description;
    private int customerID;
    private MyDate deadline;
    private String status;

    private ArrayList<TeamMember> teamMemberList;
    private ArrayList<Requirement> requirementList;

    public static final String NOT_STARTED = "Not started";
    public static final String STARTED = "Started";
    public static final String ENDED = "Ended";

    /**
     * Constructor for a project
     *
     * @param title       the project title
     * @param deadline    the project deadline
     * @param customerID  an ID for the customer
     * @param description a description of the project
     */
    public Project(String title, MyDate deadline, int customerID,
        String description)
    {
        setTitle(title);
        setDeadline(deadline);
        setCustomerID(customerID);
        setDescription(description);

        this.status = NOT_STARTED;

        this.teamMemberList = new ArrayList<>();
        this.requirementList = new ArrayList<>();
    }

    /**
     * Sets the title
     *
     * @param title the project title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Sets the deadline
     *
     * @param deadline the project deadline
     */
    public void setDeadline(MyDate deadline)
    {
        this.deadline = deadline.copy();
    }

    /**
     * Sets the customerID
     *
     * @param customerID an ID for the customer
     */
    public void setCustomerID(int customerID)
    {
        try
        {
            this.customerID = customerID;
        }
        catch (InputMismatchException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Sets the description
     *
     * @param description a description of the project
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Getter for the title
     *
     * @return the project title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Getter for the deadline
     *
     * @return the project deadline
     */
    public MyDate getDeadline()
    {
        return deadline;
    }

    /**
     * Getter for the customerID
     *
     * @return the ID of the customer
     */
    public int getCustomerID()
    {
        return customerID;
    }

    /**
     * Getter for the description
     *
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Adds a team member to the project
     *
     * @param teamMember a team member that will work on the project
     */
    public void addTeamMember(TeamMember teamMember)
    {
        teamMemberList.add(teamMember);
    }

    /**
     * Removes a team member from the project
     *
     * @param teamMember a team member that works on the project
     */
    public void removeTeamMember(TeamMember teamMember)
    {
        teamMemberList.remove(teamMember);
    }

    public TeamMember getTeamMember(TeamMember teamMember)
    {
        for (TeamMember member : teamMemberList)
        {
            if (member.equals(teamMember))
            {
                return teamMember;
            }
        }
        return null;
    }

    /**
     * Getter for the number of team members that works on the project
     *
     * @return the number of team members that works on the project
     */
    public int getNumberOfTeamMembers()
    {
        return teamMemberList.size();
    }

    /**
     * Getter for the scrum master
     *
     * @return the scrum master
     */
    public TeamMember getScrumMaster()
    {
        TeamMember scrum = null;
        for (TeamMember teamMember : teamMemberList)
        {
            if (teamMember instanceof ScrumMaster)
            {
                scrum = teamMember;
            }
        }
        return scrum;
    }

    /**
     * Getter for product owner
     *
     * @return the product owner
     */
    public TeamMember getProductOwner()
    {
        TeamMember owner = null;
        for (TeamMember teamMember : teamMemberList)
        {
            if (teamMember instanceof ProductOwner)
            {
                owner = teamMember;
            }
        }
        return owner;
    }

    /**
     * Getter for team members that are not scrum master or product owner
     *
     * @return the team members that are not scrum master or product owner
     */
    public ArrayList<TeamMember> getOnlyTeamMembers()
    {
        ArrayList<TeamMember> teamMembers = new ArrayList<>();
        for (TeamMember teamMember : teamMemberList)
        {
            if (!(teamMember instanceof ScrumMaster)
                && !(teamMember instanceof ProductOwner))
            {
                teamMembers.add(teamMember);
            }
        }
        return teamMembers;
    }

    /**
     * Getter for all team members
     *
     * @return all team members
     */
    public ArrayList<TeamMember> getAllTeamMembers()
    {
        return teamMemberList;
    }

    /**
     * Getter for a team member by name
     * @param name name of the team member
     * @return the team member with the specified name
     */
    public TeamMember getTeamMemberByName(Name name)
    {
        for (TeamMember teamMember : teamMemberList)
        {
            if (name.equals(teamMember.getName()))
            {
                return teamMember;
            }
        }
        return null;
    }

    /**
     * Getter for a team member by ID
     * @param ID ID of the team member
     * @return the team member with the specified ID
     */
    public TeamMember getTeamMemberByID(int ID)
    {
        try
        {
            for (TeamMember teamMember : teamMemberList)
            {
                if (ID == teamMember.getId())
                {
                    return teamMember;
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
     * Adds a requirement to the project
     *
     * @param requirement the requirement to be added
     */
    public void addRequirement(Requirement requirement)
    {
        requirementList.add(requirement);
    }

    /**
     * Removes a requirement from the project
     *
     * @param requirementID the ID of the requirement to be removed
     */
    public void removeRequirement(int requirementID)
    {
        try
        {
            for (int i = 0; i < requirementList.size(); i++)
            {
                if (requirementID == requirementList.get(i).getID())
                {
                    requirementList.remove(requirementList.get(i));
                }
            }
        }
        catch (InputMismatchException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Getter for the number of requirements for the project
     *
     * @return the number of requirements for the project
     */
    public int getNumberOfRequirements()
    {
        return requirementList.size();
    }

    /**
     * Getter for all the projects requirements
     *
     * @return all the projects requirements
     */
    public ArrayList<Requirement> getAllRequirements()
    {
        return requirementList;
    }

    /**
     * Reorder priority of requirements
     * @param position position to be swapped
     * @param newPosition position to be swapped to
     */
    public void reorderRequirement(int position, int newPosition)
    {
        try
        {
            Collections.swap(requirementList, position, newPosition);
        }
        catch (IndexOutOfBoundsException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Getter for the project status, will also check the status of all
     * requirements and tasks and update where needed
     *
     * @return the project status
     */
    public String getStatus()
    {
        ArrayList<Requirement> requirementListCheck = new ArrayList<>();

        if (!(status.equals(ENDED)))
        {
            for (Requirement requirement : requirementList)
            {
                if (!(requirement.getStatus().equals(NOT_STARTED)))
                {
                    status = STARTED;
                }
                if (requirement.isApproved())
                {
                    requirementListCheck.add(requirement);
                }
            }
            if (requirementListCheck.equals(requirementList))
            {
                status = ENDED;
            }
        }
        return status;
    }

    /**
     * Equals method
     *
     * @param obj object to be compared to
     * @return a boolean indicating if two instances are similar
     */
    @Override public boolean equals(Object obj)
    {
        if (!(obj instanceof Project))
        {
            return false;
        }
        Project other = (Project) obj;
        return title.equals(other.title) && description
            .equals(other.description) && customerID == other.customerID
            && deadline.equals(other.deadline) && status.equals(other.status);
    }

    /**
     * A toString method
     *
     * @return the project variables in form of a String
     */
    @Override public String toString()
    {
        return "Title: " + title + "\n" + "Description: " + description + "\n"
            + "Customer ID: " + customerID + "\n" + "Deadline: " + deadline
            + "\n" + "Status: " + status;
    }
}
