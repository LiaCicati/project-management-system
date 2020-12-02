package Model;

public class Test
{
  public static void main(String[] args)
  {
    Name name1 = new Name("Lia", "Cicati");
    Name name2 = new Name("Loredana", "Cicati");
    Name name3 = new Name("Dylan", "Peters");
    MyDate deadline = new MyDate(13, 2, 2021);
    MyDate deadline2 = new MyDate(15, 3, 2021);
    TeamMember teamMember1 = new TeamMember(name1, 2);
    TeamMember teamMember2 = new TeamMember(name2, 3);
    TeamMember scrumMaster = new ScrumMaster(name3, 58);
    TeamMember productOwner = new ProductOwner(name2, 444);

    TeamMemberList teamMemberList = new TeamMemberList();
    teamMemberList.addTeamMember(teamMember1);
    teamMemberList.addTeamMember(teamMember2);
    teamMemberList.addTeamMember(productOwner);
    teamMemberList.addTeamMember(scrumMaster);
    System.out.println(teamMemberList);
    Requirement requirement1 = new Requirement(324, 25.5, teamMember1,
        deadline);
    Requirement requirement2 = new Requirement(326, 25.5, teamMember2,
        deadline2);

    RequirementList requirementList = new RequirementList();
    requirementList.addRequirement(requirement1);
    requirementList.addRequirement(requirement2);
<<<<<<< Updated upstream

    Project project1 = new Project("Rental Company", deadline, 22,
        "blabla blabla");
    project1.addTeamMember(scrumMaster);
    project1.addTeamMember(productOwner);
    System.out.println(
        "All members for the 1st project: " + project1.getAllTeamMembers());
=======
>>>>>>> Stashed changes
    System.out.println(
        "Scrum master of the 1st project: " + project1.getScrumMaster());
    System.out.println(
        "Product owner of the 1st project: " + project1.getProductOwner());
    System.out.println("Project 1 :" + "\n" + project1);

    System.out.println(
        "Get requirement by ID from the list: " + "\n" + requirementList
            .getByID(326));
    System.out.println(
        "Get requirement by responsible team member : " + "\n" + requirementList
            .getByResponsibleTeamMember(teamMember1));
    System.out.println("Get requirement by deadline: " + "\n" + requirementList
        .getByDeadline(deadline2));

    System.out.println("Team member: " + teamMember1);
    System.out.println("Requirement: " + requirement1);
    requirement1.addTeamMember(teamMember1);
    requirement1.addTeamMember(teamMember2);
    System.out.println(
        "Team members that worked on first requirement: " + requirement1
            .getAllTeamMembers());
<<<<<<< Updated upstream

    System.out.println(requirementList);
=======
>>>>>>> Stashed changes

  }
}
