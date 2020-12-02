package Model;

import java.util.ArrayList;

public class Requirement
{
  private int ID;
  private double estimatedTime;
  private String status;
  private String type;
  public static final String NOT_STARTED = "Not started";
  public static final String STARTED = "Started";
  public static final String ENDED = "Ended";
  public static final String APPROVED = "Approved";
  public static final String REJECTED = "Rejected";
  private TeamMember responsibleTeamMember;
  private ArrayList<TeamMember> teamMembers;
  private ArrayList<Task> tasks;
  private MyDate deadline;

  public Requirement(int ID, double estimatedTime,
      TeamMember responsibleTeamMember, MyDate deadline)
  {
    setID(ID);
    setEstimatedTime(estimatedTime);
    setResponsibleTeamMember(responsibleTeamMember);
    setDeadline(deadline);
    this.status = NOT_STARTED;
    this.teamMembers = new ArrayList<>();
    this.tasks = new ArrayList<>();
  }

  public int getID()
  {
    return ID;
  }

  public TeamMember getResponsibleTeamMember()
  {
    return responsibleTeamMember;
  }

  public double getEstimatedTime()
  {
    return estimatedTime;
  }

  public String getStatus()
  {
    return status;
  }

  public String getType()
  {
    return type;
  }

  public MyDate getDeadline()
  {
    return deadline;
  }

  public void setID(int ID)
  {
    this.ID = ID;
  }

  public void setEstimatedTime(double estimatedTime)
  {
    this.estimatedTime = estimatedTime;
  }

  public void setResponsibleTeamMember(TeamMember responsibleTeamMember)
  {
    this.responsibleTeamMember = responsibleTeamMember;
  }

  public void setDeadline(MyDate deadline)
  {
    this.deadline = deadline;
  }

  public void setStatus(String status)
  {
    this.status = status;
  }

  public void addTask(Task task)
  {
    tasks.add(task);
  }

  public void removeTask(Task task)
  {
    tasks.remove(task);
  }

  public void addTeamMember(TeamMember teamMember)
  {
    teamMembers.add(teamMember);
  }

  public void removeTeamMember(TeamMember teamMember)
  {
    teamMembers.remove(teamMember);
  }

  public ArrayList<TeamMember> getAllTeamMembers()
  {
    return teamMembers;
  }

  public ArrayList<Task> getAllTasks()
  {
    return tasks;
  }

  public int countTeamMembers()
  {
    return teamMembers.size();
  }

  public int countTasks()
  {
    return tasks.size();
  }

  // somewhere here should be also the method regarding the status

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

  @Override public String toString()
  {
    String s = "";
    s += "ID: " + ID + "\n" + "estimated Time: " + estimatedTime + " hours"
        + "\n" + "Responsible Team Member: " + responsibleTeamMember + "\n"
        + "Deadline: " + deadline + "\n" + "Status: " + status;
    return s;
  }

}
