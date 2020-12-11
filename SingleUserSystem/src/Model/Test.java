//package Model;
//
//import com.sun.security.jgss.GSSUtil;
//
//public class Test
//{
//  public static void main(String[] args)
//  {
//    Name name1 = new Name("Lia", "Cicati");
//    Name name2 = new Name("Loredana", "Cicati");
//    Name name3 = new Name("Dylan", "Peters");
//    MyDate deadline = new MyDate(13, 2, 2021);
//    MyDate deadline2 = new MyDate(15, 3, 2021);
//    TeamMember teamMember1 = new TeamMember(name1, 2);
//    TeamMember teamMember2 = new TeamMember(name2, 3);
//    TeamMember scrumMaster = new ScrumMaster(name3, 58);
//    TeamMember productOwner = new ProductOwner(name2, 444);
//
//
//    TeamMemberList teamMemberList = new TeamMemberList();
//    teamMemberList.addTeamMember(teamMember1);
//    teamMemberList.addTeamMember(teamMember2);
//    teamMemberList.addTeamMember(productOwner);
//    teamMemberList.addTeamMember(scrumMaster);
//    System.out.println(teamMemberList);
//    Requirement requirement1 = new NonFunctional(324, 25.5, teamMember1,
//        deadline, "lalala");
//    Requirement requirement2 = new ProjectRelated(326, 25.5, teamMember2,
//        deadline2, "some text");
//    System.out.println("1st requirement: " + requirement1);
//
//
//
//
////
////    System.out.println("Status for 1st requirement: " + requirement1.getStatus());
////    System.out.println(requirement1.countTasks());
////    System.out.println(requirement1.getAllTasks());
////    System.out.println("Type of requirement: " + requirement1.getType());
////    System.out.println(requirement1.getType());
//
////    requirement1.setStatus(Requirement.APPROVED);
////    requirement2.setStatus(Requirement.STARTED);
//    ProjectList projectList = new ProjectList();
//
//    Project project1 = new Project("Rental Company", deadline, 22,
//        "blabla blabla");
//    Project project2 = new Project("University", deadline, 22,
//        "blabla blabla");
//    Project project3 = new Project("School", deadline, 22,
//        "blabla blabla");
//
//    RequirementList requirementList = new RequirementList();
//   requirementList.addRequirement(requirement1);
//   requirementList.addRequirement(requirement2);
////    System.out.println("HEEEI" + requirementList.getRequirements());
////
////    projectList.addProject(project1);
////    projectList.addProject(project2);
////    projectList.addProject(project3);
////
////    System.out.println("INFO: " + project1.getAllRequirements());
////    project1.addTeamMember(scrumMaster);
////    project1.addTeamMember(productOwner);
////    project1.addTeamMember(teamMember1);
////    project1.addTeamMember(teamMember2);
//////    project1.addRequirement(requirement1);
//////    project1.addRequirement(requirement2);
////
////
////    Task task1 = new Task(requirement2, 4, "Add javadoc", "fufudfduf", 30, teamMember1,deadline);
////    Task task2 = new Task(requirement1, 3, "Add javadoc", "fufudfduf", 30, teamMember1,deadline);
////    task2.setStatus(Task.STARTED);
////    task1.setStatus(Task.ENDED);
////    requirement1.addTask(task2);
////    requirement1.addTask(task1);
////    System.out.println("STATUS: " + requirement1.getStatus());
////    requirement2.addTask(task1);
////
////    TaskList tasks = new TaskList();
////    tasks.addTask(task1);
////    tasks.addTask(task2);
////
////
////
////    tasks.changeStatus("Not Started", task1);
////    System.out.println(task1);
////
////    System.out.println(teamMember1.getName());
////    System.out.println(teamMemberList.getTeamMemberByName(name1));
////    System.out.println("BY ID: " + project1.getTeamMemberByID(2));
////    System.out.println("NOW: " + project1.getAllRequirements());
////project1.reorderRequirement(1, 0);
////    System.out.println("CHANGED: " + project1.getAllRequirements());
////    System.out.println(projectList.getNumberOfProjects());
//    System.out.println("Requirement List: " + requirementList);
//    requirementList.removeRequirement(requirement2);
//    System.out.println("Requirement List: " + requirementList);
//
//    project1.addRequirement(requirement1);
//    project1.addRequirement(requirement2);
//    System.out.println("!!!! " + project1.getAllRequirements());
//    project1.removeRequirement(324);
//    System.out.println("!!!! " + project1.getAllRequirements());
//
////    teamMember1.registerTime( 40 ,task1);
////
////    System.out.println("Task 1 data: " + task1);
////    System.out.println(
////        "All members for the 1st project: " + project1.getAllTeamMembers());
////
////    System.out.println(
////        "Scrum master of the 1st project: " + project1.getScrumMaster());
////    System.out.println(
////        "Product owner of the 1st project: " + project1.getProductOwner());
////    System.out.println("Project 1 :" + "\n" + project1);
////
////    System.out.println(
////        "Get requirement by ID from the list: " + "\n" + requirementList
////            .getByID(326));
////    System.out.println(
////        "Get requirement by responsible team member : " + "\n" + requirementList
////            .getByResponsibleTeamMember(teamMember1));
////    System.out.println("Get requirement by deadline: " + "\n" + requirementList
////        .getByDeadline(deadline2));
////
////    System.out.println("Team member: " + teamMember1);
////    System.out.println("Requirement: " + requirement1);
////    requirement1.addTeamMember(teamMember1);
////    requirement1.addTeamMember(teamMember2);
////    System.out.println(
////        "Team members that worked on first requirement: " + requirement1
////            .getAllTeamMembers());
////
////    System.out.println(requirementList);
////
////    Requirement functional = new Functional(868, 50.6,teamMember1, deadline2, "I want to add");
////    System.out.println("AAAA" + functional);
////    System.out.println(requirement1.getStatus());
////    System.out.println("Status of the project: " + project1.getStatus());
////    System.out.println("1: " + requirementList);
////    requirementList.reorder(0, 1);
////    System.out.println("Changed: " + requirementList);
////
////    System.out.println(requirement1.isEnded());
////    System.out.println(requirementList.areInEndedState());
////    System.out.println(task1.isEnded());
////    System.out.println(task2.isEnded());
////    System.out.println(tasks.areInEndedState());
////    System.out.println(project1.getStatus());
//////    System.out.println(task1.getRequirementID());
//////    System.out.println(task1);
////
//////    System.out.println(requirement1);
//////    System.out.println(requirement2);
//////    System.out.println(teamMember1);
//////    System.out.println(productOwner);
//////    System.out.println(scrumMaster);
////    System.out.println("STOP!");
////    System.out.println("PROJECT 1: " + project1);
////    System.out.println(project1.getProductOwner());
//
//
//  }
//}
