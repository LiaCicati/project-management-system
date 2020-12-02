package Model;

import java.util.ArrayList;

public class Project
{
    private String title;
    private String description;
    private int customerID;
    private MyDate deadline;
    private String status;

    private ArrayList<TeamMember> teamMemberList;
    private ArrayList<Requirement> requirementList;

    public static String NOT_STARTED = "Not started";
    public static String STARTED = "Started";
    public static String ENDED = "Ended";

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

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setDeadline(MyDate deadline)
    {
        this.deadline = deadline.copy();
    }

    public void setCustomerID(int customerID)
    {
        this.customerID = customerID;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getTitle()
    {
        return title;
    }

    public MyDate getDeadline()
    {
        return deadline;
    }

    public int getCustomerID()
    {
        return customerID;
    }

    public String getDescription()
    {
        return description;
    }

    public void addTeamMember(TeamMember teamMember)
    {
        teamMemberList.add(teamMember);
    }

    public void removeTeamMember(TeamMember teamMember)
    {
        teamMemberList.remove(teamMember);
    }

    public int getNumberOfTeamMembers()
    {
        return teamMemberList.size();
    }

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

    public ArrayList<TeamMember> getAllTeamMembers()
    {
        ArrayList<TeamMember> teamMembers = new ArrayList<>();
        for (TeamMember teamMember : teamMemberList)
        {
            if (teamMember != null)
            {
                teamMembers.add(teamMember);
            }
        }
        return teamMembers;
    }

    public void addRequirement(Requirement requirement)
    {
        requirementList.add(requirement);
    }

    public void removeRequirement(int requirementID)
    {
        for(int i = 0; i < requirementList.size(); i++)
        {
            if(requirementID == requirementList.get(i).getID())
            {
                requirementList.remove(requirementList.get(i));
            }
        }
    }

    public int getNumberOfRequirements()
    {
        return requirementList.size();
    }

    public ArrayList<Requirement> getAllRequirements() //I forget if this is how to return an arraylist...
    {
        return requirementList;
    }

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

    @Override public String toString()
    {
        return "Title: " + title + "\n" + "Description: " + description + "\n"
            + "Customer ID: " + customerID + "\n" + "Deadline: " + deadline
            + "\n" + "Status: " + status;
    }
}
