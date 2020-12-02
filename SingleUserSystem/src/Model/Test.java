package Model;

public class Test
{
  public static void main(String[] args)
  {
    Name name1 = new Name("Lia", "Cicati");
    Name name2 = new Name("Loredana", "Cicati");
    MyDate deadline = new MyDate(13, 2, 2021);
    MyDate deadline2 = new MyDate(15, 3, 2021);
    TeamMember teamMember1 = new TeamMember(name1, 2);
    TeamMember teamMember2 = new TeamMember(name2, 3);
    Requirement requirement1 = new Requirement(324, 25.5, teamMember1,
        deadline);
    Requirement requirement2 = new Requirement(326, 25.5, teamMember2,
        deadline2);

    RequirementList requirementList = new RequirementList();
    requirementList.addRequirement(requirement1);
    requirementList.addRequirement(requirement2);

    System.out.println(
        "Get requirement by ID from the list: " + requirementList.getByID(326));
    System.out.println(
        "Get requirement by responsible team member : " + requirementList
            .getByResponsibleTeamMember(teamMember1));
    System.out.println("Get requirement by deadline: " + requirementList
        .getByDeadline(deadline2));

    System.out.println("Team member: " + teamMember1);
    System.out.println("Requirement: " + requirement1);
    requirement1.addTeamMember(teamMember1);
    requirement1.addTeamMember(teamMember2);
    System.out.println("Team members that worked on first requirement: " + requirement1.getAllTeamMembers());

    System.out.println("All requirements: " + requirementList);
  }
}
