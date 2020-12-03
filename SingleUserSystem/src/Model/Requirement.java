package Model;

import java.util.ArrayList;

/**
 * @author Lia Cicati
 * @version v.1 : 2nd December 2020
 */
public class Requirement
{
  private int ID;
  private double estimatedTime;
  private String status;
  private String type;
  private double timeSpent;
  public static final String NOT_STARTED = "Not started";
  public static final String STARTED = "Started";
  public static final String ENDED = "Ended";
  public static final String APPROVED = "Approved";
  public static final String REJECTED = "Rejected";
  private TeamMember responsibleTeamMember;
  private ArrayList<TeamMember> teamMembers;
  private ArrayList<Task> tasks;
  private MyDate deadline;

  /**
   * Contructor for the requirement
   *
   * @param ID                    the id of the requirement
   * @param estimatedTime         the estimated time per completion of a requirement
   * @param responsibleTeamMember the responsible team member for a requirement
   * @param deadline              the deadline for the requirement
   */
  public Requirement(int ID, double estimatedTime,
      TeamMember responsibleTeamMember, MyDate deadline)
  {
    setID(ID);
    setEstimatedTime(estimatedTime);
    setResponsibleTeamMember(responsibleTeamMember);
    setDeadline(deadline);
    this.timeSpent = 0;
    this.status = NOT_STARTED;
    this.teamMembers = new ArrayList<>();
    this.tasks = new ArrayList<>();
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
    for (Task task : tasks)
    {
      this.timeSpent = timeSpent + task.getTimeSpent();
    }
    return timeSpent;
  }

  /**
   * Getter for the requirement status
   *
   * @return the current status of the requirement
   */
  public String getStatus()
  {
    return status;
  }

  /**
   * Getter for the requirement type
   *
   * @return the type of a specific requirement
   */
  public String getType()
  {
    return type;
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
    this.ID = ID;
  }

  /**
   * Sets the estimated time per completion of a requirement
   *
   * @param estimatedTime the estimated time per completion
   */
  public void setEstimatedTime(double estimatedTime)
  {
    this.estimatedTime = estimatedTime;
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
   * Adding a task to a specific requirement
   *
   * @param task the added task
   */
  public void addTask(Task task)
  {
    tasks.add(task);
  }

  /**
   * Removing a task from a specific requirement
   *
   * @param task the removed task
   */
  public void removeTask(Task task)
  {
    tasks.remove(task);
  }

  /**
   * Adding a team member that worked on the requirement
   *
   * @param teamMember the added team member
   */
  public void addTeamMember(TeamMember teamMember)
  {
    teamMembers.add(teamMember);
  }

  /**
   * Removing a team member that worked on a specific requirement
   *
   * @param teamMember the removed team member
   */
  public void removeTeamMember(TeamMember teamMember)
  {
    teamMembers.remove(teamMember);
  }

  /**
   * Getting all team members that worked on a specific requirement
   *
   * @return an array list of team members that worked on the requirement
   */
  public ArrayList<TeamMember> getAllTeamMembers()
  {
    return teamMembers;
  }

  /**
   * Getting all the tasks of a requirement
   *
   * @return an array list of all tasks that represent a requirement
   */
  public ArrayList<Task> getAllTasks()
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
    return teamMembers.size();
  }

  /**
   * Getting the total number of tasks of a requirement
   *
   * @return total number of tasks
   */
  public int countTasks()
  {
    return tasks.size();
  }

  /**
   * Checking if a requirement is in Ended state
   * @return true if the requirement is ended and false if not
   */
  public boolean isEnded()
  {
    return status.equals(Requirement.ENDED);
  }

  /**
   * Checking if two requirements are the same
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
    return ID == other.ID && estimatedTime == other.estimatedTime
        && responsibleTeamMember.equals(other.responsibleTeamMember)
        && deadline == other.deadline && status.equals(other.status);
  }

  /**
   * Getting the information about a requirement
   *
   * @return a string with all needed information about a requirement
   */
  @Override public String toString()
  {
    String s = "";
    s += "ID: " + ID + "\n" + "estimated Time: " + estimatedTime + " hours"
        + "\n" + "Responsible Team Member: " + responsibleTeamMember + "\n"
        + "Deadline: " + deadline + "\n" + "Status: " + status + "\n";
    return s;
  }

}
