package Model;

import java.util.ArrayList;

public class Requirement
{
  private int ID;
  private double estimatedTime;
  public static final String NOT_STARTED = "Not started";
  public static final String STARTED = "Started";
  public static final String ENDED = "Ended";
  public static final String APPROVED = "Approved";
  public static final String REJECTED = "Rejected";
  private TeamMember responsibleTeamMember;
  private ArrayList<TeamMember> teamMembers;
  private ArrayList<Task> tasks;
//  private MyDate deadline;



}
