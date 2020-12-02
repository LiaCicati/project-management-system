package Model;

import java.util.ArrayList;

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

  public Task(Requirement requirementID, int ID, String title,
      String description, double estimatedTime,
      TeamMember responsibleTeamMember, MyDate deadline)
  {
    setID(ID);
    setTitle(title);
    //    setTimeSpent(timeSpent, teamMember);
    setDescription(description);
    setEstimatedTime(estimatedTime);
    setResponsibleTeamMember(responsibleTeamMember);
    setStatus(status);
    setDeadline(deadline);
    this.requirementID = requirementID;
    this.teamMembers = new ArrayList<>();

  }

  public int getID()
  {
    return ID;
  }

  public String getTitle()
  {
    return title;
  }

  public String getDescription()
  {
    return description;
  }

  public double getEstimatedTime()
  {
    return estimatedTime;
  }

  public double getTimeSpent()
  {
    return timeSpent;
  }

  public TeamMember getResponsibleTeamMember()
  {
    return responsibleTeamMember;
  }

  public MyDate getDeadline()
  {
    return deadline;
  }

  public String getStatus()
  {
    return status;
  }

  public void setID(int ID)
  {
    this.ID = ID;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public void setEstimatedTime(double estimatedTime)
  {
    this.estimatedTime = estimatedTime;
  }

  //  public void setTimeSpent(double timeSpent, TeamMember teamMember)
  //  {
  //    this.timeSpent = timeSpent;
  //    this.teamMember = teamMember;
  //  }

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
    this.status = NOT_STARTED;
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

  public int countTeamMembers()
  {
    return teamMembers.size();
  }

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

  @Override public String toString()
  {
    return "ID:" + ID + "\n"+ "Requirement:" + requirementID+ "\n" + "Title:" + title+ "\n"
        + "Description:" + description + "\n"+ "Responsible team member:"
        + responsibleTeamMember + "\n"+ "Estimated time:" + estimatedTime+ "\n"
        + "Time spent:" + timeSpent+ "\n" + "Deadline" + deadline + "\n"+ "Team Members:"
        + teamMembers + "\n"+ "Status" + status;
  }
}
