package Model;

import java.util.ArrayList;

/**
 * @author Loredana Cicati
 * @version v.1 : 2nd December 2020
 */
public class Task
{
  private int ID;
  private String title;
  private double estimatedTime;
  private double timeSpent;
  private String description;
  private String status;
  private ArrayList<TeamMember> teamMembers;
  private TeamMember responsibleTeamMember;
  private Requirement requirementID;
  private MyDate deadline;
  public static final String NOT_STARTED = "Not Started";
  public static final String STARTED = "Started";
  public static final String ENDED = "Ended";

  /**
   * Constructor for the task
   *
   * @param requirementID         the ID of the requirement
   * @param ID                    the ID if the task
   * @param title                 the title of the task
   * @param description           the description for the task
   * @param estimatedTime         the estimated time per completion of a task
   * @param responsibleTeamMember the responsible team member for the task
   * @param deadline              the deadline for the task
   */
  public Task(Requirement requirementID, int ID, String title,
      String description, double estimatedTime,
      TeamMember responsibleTeamMember, MyDate deadline)
  {
    setID(ID);
    setTitle(title);
    setTimeSpent(0);
    setDescription(description);
    setEstimatedTime(estimatedTime);
    setResponsibleTeamMember(responsibleTeamMember);
    setStatus(status);
    setDeadline(deadline);
    this.requirementID = requirementID;
    this.teamMembers = new ArrayList<>();

  }

  /**
   * Getter for the task's ID
   *
   * @return the ID of the task
   */
  public int getID()
  {
    return ID;
  }

  /**
   * Getter for the task's title
   *
   * @return the title of the task
   */
  public String getTitle()
  {
    return title;
  }

  /**
   * Getter for the task's description
   *
   * @return the description of the task
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * Getter for the estimated time per completion of a task
   *
   * @return the task's estimated time
   */
  public double getEstimatedTime()
  {
    return estimatedTime;
  }

  /**
   * Getter for the actual time spent per completion of a task
   *
   * @return the task's actual time
   */
  public double getTimeSpent()
  {
    return timeSpent;
  }

  /**
   * Getter for the responsible team member of a task
   *
   * @return the responsible team member
   */
  public TeamMember getResponsibleTeamMember()
  {
    return responsibleTeamMember;
  }

  /**
   * Getter for the task's deadline
   *
   * @return the task's deadline
   */
  public MyDate getDeadline()
  {
    return deadline;
  }

  /**
   * Getter for the status of a task
   *
   * @return the status of a specific task
   */
  public String getStatus()
  {
    return status;
  }

  /**
   * Sets the task ID
   *
   * @param ID the ID
   */
  public void setID(int ID)
  {
    this.ID = ID;
  }

  /**
   * Sets the title of a task
   *
   * @param title the title
   */
  public void setTitle(String title)
  {
    this.title = title;
  }

  /**
   * Sets the description of a task
   *
   * @param description the description
   */
  public void setDescription(String description)
  {
    this.description = description;
  }

  /**
   * Sets the estimated time per completion of a task
   *
   * @param estimatedTime the estimated time per completion
   */
  public void setEstimatedTime(double estimatedTime)
  {
    this.estimatedTime = estimatedTime;
  }

  /**
   * Setting the time spent
   * @param timeSpent the time spent
   */
  public void setTimeSpent(double timeSpent)
  {
    this.timeSpent = timeSpent;
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
   * Sets the deadline for a specific task
   *
   * @param deadline the deadline
   */
  public void setDeadline(MyDate deadline)
  {
    this.deadline = deadline;
  }

  /**
   * Sets the status for a specific task
   *
   * @param status the status
   */
  public void setStatus(String status)
  {
    this.status = NOT_STARTED;
  }

  /**
   * Adding a team member to the task
   *
   * @param teamMember the added team member
   */
  public void addTeamMember(TeamMember teamMember)
  {
    teamMembers.add(teamMember);
  }

  /**
   * Removing a team member that worked on a specific task
   *
   * @param teamMember the removed team member
   */
  public void removeTeamMember(TeamMember teamMember)
  {
    teamMembers.remove(teamMember);
  }

  /**
   * Getting all team members that worked on a specific task
   *
   * @return an array list of team members that worked on the task
   */
  public ArrayList<TeamMember> getAllTeamMembers()
  {
    return teamMembers;
  }

  /**
   * Getting the total number of team members that worked on a task
   *
   * @return total number of team members
   */
  public int countTeamMembers()
  {
    return teamMembers.size();
  }

  /**
   * Checking if two tasks are the same
   *
   * @param obj the task compared to
   * @return true if the tasks are the same or false if not
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Task))
    {
      return false;
    }
    Task other = (Task) obj;
    return ID == other.ID && title.equals(other.title) && description
        .equals(other.description) && estimatedTime == other.estimatedTime
        && timeSpent == other.timeSpent && status.equals(other.status)
        && responsibleTeamMember.equals(other.responsibleTeamMember)
        && requirementID.equals(other.requirementID) && deadline
        .equals(other.deadline) && teamMembers.equals(other.teamMembers);
  }

  /**
   * Getting the information about a specific task
   *
   * @return a string with all needed information about a task
   */
  @Override public String toString()
  {
    return "ID:" + ID + "\n" + "Requirement:" + requirementID + "\n" + "Title:"
        + title + "\n" + "Description:" + description + "\n"
        + "Responsible team member:" + responsibleTeamMember + "\n"
        + "Estimated time:" + estimatedTime + "\n" + "Time spent:" + timeSpent
        + "\n" + "Deadline" + deadline + "\n" + "Team Members:" + teamMembers
        + "\n" + "Status" + status;
  }
}