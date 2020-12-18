package Model;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * @author Lia Cicati
 * @version v.1 : 2nd December 2020
 */
public class Requirement
{
    private int ID;
    private double estimatedTime;
    private String status;
    private String userStory;
    private Type type;
    private double timeSpent;
    public static final String NOT_STARTED = "Not Started";
    public static final String STARTED = "Started";
    public static final String ENDED = "Ended";
    public static final String APPROVED = "Approved";
    public static final String REJECTED = "Rejected";
    private TeamMember responsibleTeamMember;
    private TeamMemberList teamMembers;
    private TaskList tasks;
    private MyDate deadline;

    /**
     * Constructor for the requirement
     * @param ID the id
     * @param userStory the user story text
     * @param type the type
     * @param estimatedTime the estimated time
     * @param responsibleTeamMember the responsible team member
     * @param deadline the deadline
     */
    public Requirement(int ID, String userStory, Type type,
        double estimatedTime, TeamMember responsibleTeamMember, MyDate deadline)
    {
        setID(ID);
        setEstimatedTime(estimatedTime);
        setResponsibleTeamMember(responsibleTeamMember);
        setDeadline(deadline);
        setUserStory(userStory);
        setType(type);
        this.timeSpent = 0;
        this.status = NOT_STARTED;
        this.teamMembers = new TeamMemberList();
        this.tasks = new TaskList();
    }

    /**
     * Getter for the requirement's id
     *
     * @return the id of the requirement
     */
    public int getID()
    {
        return ID;
    }

    /**
     * Getter for the responsible team member of a requirement
     *
     * @return the responsible team member
     */
    public TeamMember getResponsibleTeamMember()
    {
        return responsibleTeamMember;
    }

    /**
     * Getter for the estimated time per completion of a requirement
     *
     * @return the estimated time
     */
    public double getEstimatedTime()
    {
        return estimatedTime;
    }

    /**
     * Getter for time spent on the requirement
     *
     * @return the time spent on requirement
     */
    public double getTimeSpent()
    {
        timeSpent = 0;
        for (Task task : tasks.getAllTasks())
        {
            this.timeSpent = timeSpent + task.getTimeSpent();
        }
        return timeSpent;
    }

    /**
     * Getter for the user story
     *
     * @return the user story of the requirement
     */
    public String getUserStory()
    {
        return userStory;
    }

    /**
     * Getter for type of a requirement
     *
     * @return the type of the requirement
     */
    public Type getType()
    {
        return type;
    }

    /**
     * Getter for the requirement status, will also check the status of all
     * tasks and update where needed
     *
     * @return the current status of the requirement
     */
    public String getStatus()
    {
        if (tasks.getSize() != 0) // if the task list is not empty
        {
            if (status.equals(Requirement.STARTED) || status.equals(
                Requirement.ENDED)) // checks if the status of the requirement is in Started or Ended state
            {
                boolean check = true;
                for (int i = 0;
                     i < tasks.getSize(); i++) // loop through all tasks
                    if (!tasks.getTask(i)
                        .isEnded()) // if none is Ended go to next statement
                    {
                        check = false;
                        break;
                    }
                if (check) // if all tasks are in Ended state
                {
                    setStatus(Requirement.ENDED); // Requirement is Ended
                }
                else // if not
                {
                    setStatus(Requirement.STARTED); // Requirement is Started
                }
            }
            if (status.equals(Requirement.NOT_STARTED) || status.equals(
                Requirement.STARTED)) // checks if Requirement status is Not Started or Started
            {
                boolean check = true;
                for (int i = 0;
                     i < tasks.getSize(); i++) // loop through all tasks
                    if (!tasks.getTask(i).getStatus().equals(
                        Task.NOT_STARTED)) // if none has Not Started status go to next statement
                    {
                        check = false;
                        break;
                    }
                if (check) // if all tasks are Not Started
                {
                    setStatus(
                        Requirement.NOT_STARTED); // Requirement is also Not Started
                }
                else
                {
                    setStatus(Requirement.STARTED);
                }
            }
        }
        else // the case when the task list is empty
        {
            status = Requirement.NOT_STARTED;
        }
        return status;
    }

    /**
     * Getter for the requirement deadline
     *
     * @return the deadline of a requirement
     */
    public MyDate getDeadline()
    {
        return deadline;
    }

    /**
     * Sets the id of a requirement
     *
     * @param ID the id
     */
    public void setID(int ID)
    {
        try
        {
            this.ID = ID;
        }
        catch (InputMismatchException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Sets the estimated time per completion of a requirement
     *
     * @param estimatedTime the estimated time per completion
     */
    public void setEstimatedTime(double estimatedTime)
    {
        try
        {
            this.estimatedTime = estimatedTime;
        }
        catch (InputMismatchException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Sets the user story of the requirement
     *
     * @param userStory the user story
     */
    public void setUserStory(String userStory)
    {
        this.userStory = userStory;
    }

    /**
     * Sets the type of the requirement
     *
     * @param type the requirement's type
     */
    public void setType(Type type)
    {
        this.type = type;
    }

    /**
     * Sets the responsible team member of a requirement
     *
     * @param responsibleTeamMember the responsible team member
     */
    public void setResponsibleTeamMember(TeamMember responsibleTeamMember)
    {
        this.responsibleTeamMember = responsibleTeamMember;
    }

    /**
     * Sets the deadline for the requirement
     *
     * @param deadline the deadline
     */
    public void setDeadline(MyDate deadline)
    {
        this.deadline = deadline;
    }

    /**
     * Sets the status of the requirement
     *
     * @param status the status
     */
    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * Edits the requirement
     *
     * @param ID                    the id
     * @param userStory             the user story
     * @param type                  the type
     * @param estimatedTime         the estimated time
     * @param responsibleTeamMember the responsible team member
     * @param deadline              the deadline
     */
    public void editRequirement(int ID, String userStory, Type type,
        double estimatedTime, TeamMember responsibleTeamMember, MyDate deadline)
    {
        setID(ID);
        setUserStory(userStory);
        setType(type);
        setEstimatedTime(estimatedTime);
        setResponsibleTeamMember(responsibleTeamMember);
        setDeadline(deadline);
    }

    /**
     * Adding a task to a specific requirement
     *
     * @param task the added task
     */
    public void addTask(Task task)
    {
        for (int i = 0; i < tasks.getSize(); i++)
            if (tasks.getTask(i).getID() == task.getID())
            {
                throw new IllegalArgumentException(
                    "A task with this ID already exists");
            }
        tasks.addTask(task);
    }

    /**
     * Removing a task from a specific requirement
     *
     * @param task the removed task
     */
    public void removeTask(Task task)
    {
        tasks.removeTask(task);
    }

    /**
     * Adding a team member that worked on the requirement
     *
     * @param teamMember the added team member
     */
    public void addTeamMember(TeamMember teamMember)
    {
        teamMembers.addTeamMember(teamMember);
    }

    /**
     * Removing a team member that worked on a specific requirement
     *
     * @param teamMember the removed team member
     */
    public void removeTeamMember(TeamMember teamMember)
    {
        teamMembers.removeTeamMember(teamMember);
    }

    /**
     * Getting all team members that worked on a specific requirement
     *
     * @return an array list of team members that worked on the requirement
     */
    public TeamMemberList getAllTeamMembers()
    {
        return teamMembers;
    }

    /**
     * Getting all the tasks of a requirement
     *
     * @return an array list of all tasks that represent a requirement
     */
    public TaskList getAllTasks()
    {
        return tasks;
    }

    /**
     * Getting the total number of team members that worked on a requirement
     *
     * @return total number of team members
     */
    public int countTeamMembers()
    {
        return teamMembers.getSize();
    }

    /**
     * Getting the total number of tasks of a requirement
     *
     * @return total number of tasks
     */
    public int countTasks()
    {
        return tasks.getSize();
    }

    /**
     * Checking if a requirement is in Ended state
     *
     * @return true if the requirement is ended and false if not
     */
    public boolean isEnded()
    {
        return status.equals(Requirement.ENDED);
    }

    /**
     * Checking if a requirement is Approved
     *
     * @return true if the requirement has approved state and false if not
     */
    public boolean isApproved()
    {
        return status.equals(Requirement.APPROVED);
    }

    /**
     * Checking if two requirements are the same
     *
     * @param obj the requirement compared to
     * @return true if the requirements are the same or false if not
     */
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Requirement))
        {
            return false;
        }
        Requirement other = (Requirement) obj;
        return ID == other.ID && userStory.equals(other.userStory)
            && estimatedTime == other.estimatedTime && responsibleTeamMember
            .equals(other.responsibleTeamMember) && deadline == other.deadline
            && status.equals(other.status) && type.equals(other.type);
    }

    /**
     * Getting the information about a requirement
     *
     * @return a string with all needed information about a requirement
     */
    @Override public String toString()
    {
        String s = "";
        s += "ID: " + ID + "\n" + "User Story: " + userStory + "\n"
            + "estimated Time: " + estimatedTime + " hours" + "\n"
            + "Responsible Team Member: " + responsibleTeamMember + "\n"
            + "Deadline: " + deadline + "\n" + "Status: " + status + "\n"
            + "Type: " + type + "\n";
        return s;
    }

    /**
     * Setter for timeSpent
     * @param timeSpent time spent on requirement
     */
    public void setTimeSpent(double timeSpent)
    {
        this.timeSpent = timeSpent;
    }

    /**
     * setter for taskList
     * @param taskList the list
     */
    public void setTaskList(TaskList taskList)
    {
        this.tasks = taskList;
    }
}